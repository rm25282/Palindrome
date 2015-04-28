package com.richard.memorystore.udp;

public class SharkTransformer {

    public SharkQuote transform(byte[] buffer) {
        System.out.println("Got to transformer!!!!!!!!!!!!!!!!!!!!");
        String[] data = new String(buffer).split(",");
        return new SharkQuote(data[0], Double.parseDouble(data[1]));
    }
}