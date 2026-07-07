package com.ulab;

/**
 * Demonstrates barcode generation and decoding.
 */
public class Main {

    public static void main(String[] args) {

        // Sample laboratory data to encode.
        String data = "SampleID:12345|Patient:Ali|Test:Blood";

        // Output barcode image file.
        String path = "barcode.png";

        // Generate the barcode image.
        BarcodeGenerator.generate(data, path);

        // Decode the generated barcode.
        BarcodeScanner.decodeBarcode(path);
    }
}
