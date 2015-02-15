package com.richard.memorystore.rest;

import static org.junit.Assert.*;

import org.junit.Test;

public class KeyValueControllerTest {

    @Test
    public void addEntryToMemoryStore() {
        KeyValueController controller = new KeyValueController();
        controller.addToMemoryStore("One", "1");
        assertEquals("1", controller.getMemoryStore().getValue("One"));
    }
    
    @Test
    public void getValueFromMemoryStore() {
        KeyValueController controller = new KeyValueController();
        controller.addToMemoryStore("One", "1");
        assertEquals("1", controller.getValueWithKey("One"));
    }

}
