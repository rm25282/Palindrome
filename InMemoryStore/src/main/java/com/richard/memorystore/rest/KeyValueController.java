package com.richard.memorystore.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.richard.memorystore.MemoryStore;

@RestController
public class KeyValueController {
    
    private MemoryStore memoryStore = new MemoryStore();

    @RequestMapping("/memorystoreadd")
    public String addToMemoryStore(@RequestParam(value="key") String key, @RequestParam(value="value") String value) {
        memoryStore.add(key, value);
        return "OK";
    }

    @RequestMapping("/memorystoreget")
    public String getValueWithKey(@RequestParam(value="key") String key) {
        return memoryStore.getValue(key);
    }
    
    public MemoryStore getMemoryStore() {
        return this.memoryStore;
    }
}