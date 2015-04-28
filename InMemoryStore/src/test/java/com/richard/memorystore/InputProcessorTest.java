package com.richard.memorystore;

import static org.junit.Assert.*;

import org.junit.Test;

import com.richard.memorystore.processor.InputProcessor;
import com.richard.memorystore.rest.KeyValue;

public class InputProcessorTest {

    @Test
    public void parseLineWithKeyAndValue() {
        InputProcessor inputProcessor = new InputProcessor();
        
        String line = "key=1,value=1";
        
        KeyValue keyvalue = new KeyValue("1", "1");
        
        compareKeyValue(keyvalue, inputProcessor.processLine(line));
        
    }

    private void compareKeyValue(KeyValue expectedKeyValue, KeyValue processedKeyValue) {
        
        assertEquals(expectedKeyValue.getKey(), processedKeyValue.getKey());
        
        assertEquals(expectedKeyValue.getValue(), processedKeyValue.getValue());
    }

}
