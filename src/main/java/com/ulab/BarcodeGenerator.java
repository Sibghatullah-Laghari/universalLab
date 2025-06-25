package com.ulab;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class BarcodeGenerator {

    public static void generate(String data, String filePath) {
        try {
            BitMatrix matrix = new MultiFormatWriter()
                    .encode(data, BarcodeFormat.CODE_128, 300, 100);
            Path path = FileSystems.getDefault().getPath(filePath);
            MatrixToImageWriter.writeToPath(matrix, "PNG", path);
            System.out.println("✅ Barcode saved to " + filePath);
        } catch (Exception e) {
            System.err.println("❌ Error: " + e.getMessage());
        }
    }
}
