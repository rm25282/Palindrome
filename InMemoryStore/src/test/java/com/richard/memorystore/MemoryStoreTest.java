package com.richard.memorystore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.richard.memorystore.MemoryStore;

public class MemoryStoreTest {
    
    private MemoryStore memoryStore = null;
    
    @Before
    public void setup() {
        memoryStore = new MemoryStore();
    }
    

    @Test
    public void emptyStoreWhenCreated() {
        assertEquals(0, memoryStore.getSize());
    }
    
    @Test
    public void addKeyValueAndSizeisOne() {
        memoryStore.add("One", "1");
        assertEquals(1, memoryStore.getSize());
    }
    
    @Test
    public void addKeyValueAndGetKeyValue() {
        memoryStore.add("One", "1");
        assertEquals("1", memoryStore.getValue("One"));
    }
    
    @Test
    public void addMultipleKeyValueAndGetSingleKeyValue() {
        memoryStore.add("One", "1");
        memoryStore.add("Two", "2");
        memoryStore.add("Three", "3");
        memoryStore.add("Four", "4");
        assertEquals("2", memoryStore.getValue("Two"));
    }

    @Test
    public void addMultipleKeyValueAndGetMultipleKeyValue() {
        memoryStore.add("One", "1");
        memoryStore.add("Two", "2");
        memoryStore.add("Three", "3");
        memoryStore.add("Four", "4");
        
        assertEquals("1", memoryStore.getValue("One"));
        assertEquals("2", memoryStore.getValue("Two"));
        assertEquals("3", memoryStore.getValue("Three"));
        assertEquals("4", memoryStore.getValue("Four"));
    }
    
    @Test
    public void gettingNullWhenAskingForMissingKey() {
        assertNull(memoryStore.getValue("One"));
    }
    
    @Test
    public void addingTwoKeyValuesTheSameIsAccepted() {
        memoryStore.add("One", "1");
        memoryStore.add("One", "1");
        assertEquals("1", memoryStore.getValue("One"));
    }
    
    @Test
    public void addingTwoKeyValuesOverwritesTheFirst() {
        memoryStore.add("One", "1");
        memoryStore.add("One", "1");
        assertEquals(1, memoryStore.getSize());
    }
    
    @Test
    public void addingTwoKeyDifferentValuesOverwritesTheFirst() {
        memoryStore.add("One", "1");
        memoryStore.add("One", "2");
        assertEquals("2", memoryStore.getValue("One"));
    }
    
    @Test
    public void askingForNullKeyReturnsNull() {
        assertNull(memoryStore.getValue(null));
    }
}
