package com.example.lukey.trc;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.EnumMap;
import java.util.Map;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lukey.trc.Common.Common;
import com.example.lukey.trc.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.mancj.materialsearchbar.EditTextStyleHelper;

public class BarcodeCreation extends Activity {

    EditText enterBarcode;
    TextView display, barcodeDisplay;
    ImageView barcodeImage;
    Button generate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode_creation);
        ;

        enterBarcode = (EditText) findViewById(R.id.enterBarcode);
        barcodeDisplay = (TextView) findViewById(R.id.barcodeDisplay);
        barcodeImage = (ImageView) findViewById(R.id.barcodeImage);
        generate = (Button) findViewById(R.id.generate);


        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // barcode data
                //String barcode_data = "123456";
                String barcode_data = (enterBarcode.getText().toString());

                // barcode image
                Bitmap bitmap = null;
                //ImageView iv = new ImageView(this);

                try {

                    bitmap = encodeAsBitmap(barcode_data, BarcodeFormat.CODE_128, 600, 300);
                    barcodeImage.setImageBitmap(bitmap);

                } catch (WriterException e) {
                    e.printStackTrace();
                }

                //l.addView(iv);

                //barcode text
                //TextView tv = new TextView(this);
                //tv.setGravity(Gravity.CENTER_HORIZONTAL);
                barcodeDisplay.setText(barcode_data);

                //z\l.addView(tv);

            }

            /**************************************************************
             * getting from com.google.zxing.client.android.encode.QRCodeEncoder
             *
             * See the sites below
             * http://code.google.com/p/zxing/
             * http://code.google.com/p/zxing/source/browse/trunk/android/src/com/google/zxing/client/android/encode/EncodeActivity.java
             * http://code.google.com/p/zxing/source/browse/trunk/android/src/com/google/zxing/client/android/encode/QRCodeEncoder.java
             */

            private static final int WHITE = 0xFFFFFFFF;
            private static final int BLACK = 0xFF000000;

            Bitmap encodeAsBitmap(String contents, BarcodeFormat format, int img_width, int img_height) throws WriterException {
                String contentsToEncode = contents;
                if (contentsToEncode == null) {
                    return null;
                }
                Map<EncodeHintType, Object> hints = null;
                String encoding = guessAppropriateEncoding(contentsToEncode);
                if (encoding != null) {
                    hints = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
                    hints.put(EncodeHintType.CHARACTER_SET, encoding);
                }
                MultiFormatWriter writer = new MultiFormatWriter();
                BitMatrix result;
                try {
                    result = writer.encode(contentsToEncode, format, img_width, img_height, hints);
                } catch (IllegalArgumentException iae) {
                    // Unsupported format
                    return null;
                }
                int width = result.getWidth();
                int height = result.getHeight();
                int[] pixels = new int[width * height];
                for (int y = 0; y < height; y++) {
                    int offset = y * width;
                    for (int x = 0; x < width; x++) {
                        pixels[offset + x] = result.get(x, y) ? BLACK : WHITE;
                    }
                }

                Bitmap bitmap = Bitmap.createBitmap(width, height,
                        Bitmap.Config.ARGB_8888);
                bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
                return bitmap;

            }

            public String guessAppropriateEncoding(CharSequence contents) {
                // Very crude at the moment
                for (int i = 0; i < contents.length(); i++) {
                    if (contents.charAt(i) > 0xFF) {
                        return "UTF-8";
                    }
                }
                return null;
            }

        });

        takeScreenshot();

    }

    private void takeScreenshot() {
        Date now = new Date();
        android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss", now);

        try {
            // image naming and path  to include sd card  appending name you choose for file
           // String mPath = Environment.getExternalStorageDirectory().toString() + "/" + now + ".jpg";
            String mPath = Environment.getExternalStorageDirectory().getAbsolutePath()+ "/hello.jpg";
            Toast.makeText(BarcodeCreation.this,"Screenshot Reached",Toast.LENGTH_SHORT).show();

            // create bitmap screen capture
            View v1 = getWindow().getDecorView().getRootView();
            v1.setDrawingCacheEnabled(true);
            Bitmap bitmap = Bitmap.createBitmap(v1.getDrawingCache());
            v1.setDrawingCacheEnabled(false);

            File imageFile = new File(mPath);

            FileOutputStream outputStream = new FileOutputStream(imageFile);
            int quality = 100;
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream);
            outputStream.flush();
            outputStream.close();

            openScreenshot(imageFile);
        } catch (Throwable e) {
            // Several error may come out with file handling or DOM
            e.printStackTrace();
        }
    }

    private void openScreenshot(File imageFile) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        Uri uri = Uri.fromFile(imageFile);
        intent.setDataAndType(uri, "image/*");
        startActivity(intent);
    }
}