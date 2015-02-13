package com.richard.memorystore;

import java.util.Hashtable;
import java.util.Map;

public class MemoryStore {
    
    Map<String, String> map = new Hashtable<String, String>(); 

    public int getSize() {
        return map.size();
    }

    public void add(String key, String value) {
        map.put(key, value);
    }

    public String getValue(String key) {
        if (key == null) {
            return null;
        }
        return map.get(key);
    }

}
