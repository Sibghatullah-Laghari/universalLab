package com.ulab;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Utility class for decoding barcode images.
 */
public class BarcodeScanner {

    /**
     * Reads a barcode image and prints the decoded content.
     */
    public static void decodeBarcode(String filePath) {
        try {
            // Load the barcode image from disk.
            File file = new File(filePath);
            BufferedImage image = ImageIO.read(file);

            // Verify that the image was loaded successfully.
            if (image == null) {
                System.out.println("❌ Could not read image.");
                return;
            }

            // Prepare the image for barcode decoding.
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            // Decode the barcode and display its contents.
            Result result = new MultiFormatReader().decode(bitmap);
            System.out.println("✅ Decoded barcode data: " + result.getText());

        } catch (Exception e) {
            // Handle decoding or file-related errors.
            System.out.println("❌ Error decoding barcode: " + e.getMessage());
        }
    }
}
