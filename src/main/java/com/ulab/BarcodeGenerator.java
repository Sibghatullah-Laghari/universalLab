package com.ulab;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;

import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * Utility class for generating barcode images.
 */
public class BarcodeGenerator {

    /**
     * Generates a CODE_128 barcode and saves it as a PNG image.
     */
    public static void generate(String data, String filePath) {
        try {
            // Create the barcode matrix from the provided data.
            BitMatrix matrix = new MultiFormatWriter()
                    .encode(data, BarcodeFormat.CODE_128, 300, 100);

            // Create the output file path.
            Path path = FileSystems.getDefault().getPath(filePath);

            // Write the barcode image as a PNG file.
            MatrixToImageWriter.writeToPath(matrix, "PNG", path);

            System.out.println("✅ Barcode saved to " + filePath);
        } catch (Exception e) {
            // Display any generation errors.
            System.err.println("❌ Error: " + e.getMessage());
        }
    }
}
