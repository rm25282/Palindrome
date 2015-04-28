package com.richard.memorystore.processor;

import org.apache.catalina.util.StringParser;

import com.richard.memorystore.rest.KeyValue;

public class InputProcessor {

    public KeyValue processLine(String line) {
        String[] keyValue = line.split(",");
        
        String key = null;
        String value = null;
        
        for (String string : keyValue) {
            if (string.startsWith("key")) {
                key = string.substring(string.indexOf("=") + 1);
            } else if (string.startsWith("value")) {
                value = string.substring(string.indexOf("=") + 1);
            }
        }
        
        return new KeyValue(key, value);
    }

}
