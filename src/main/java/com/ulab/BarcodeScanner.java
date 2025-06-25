package com.ulab;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class BarcodeScanner {

    public static void decodeBarcode(String filePath) {
        try {
            File file = new File(filePath);
            BufferedImage image = ImageIO.read(file);
            if (image == null) {
                System.out.println("❌ Could not read image.");
                return;
            }

            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            Result result = new MultiFormatReader().decode(bitmap);
            System.out.println("✅ Decoded barcode data: " + result.getText());

        } catch (Exception e) {
            System.out.println("❌ Error decoding barcode: " + e.getMessage());
        }
    }
}
