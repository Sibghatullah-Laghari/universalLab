package com.ulab;

public class Main {
    public static void main(String[] args) {
        String data = "SampleID:12345|Patient:Ali|Test:Blood";
        String path = "barcode.png";

        BarcodeGenerator.generate(data, path);    // Create barcode
        BarcodeScanner.decodeBarcode(path);       // Read it back
    }
}
