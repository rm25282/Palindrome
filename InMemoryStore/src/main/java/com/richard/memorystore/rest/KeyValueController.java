package com.richard.memorystore.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.richard.memorystore.MemoryStore;

@RestController
public class KeyValueController {
    
    private MemoryStore memoryStore = new MemoryStore();

    @RequestMapping("/memorystoreadd")
    public String addToMemoryStore(@RequestParam(value="key",required=true) String key, @RequestParam(value="value",required=true) String value) {
        memoryStore.add(key, value);
        return "OK";
    }

    @RequestMapping("/memorystoreget")
    public @ResponseBody KeyValue getValueWithKey(@RequestParam(value="key",required=true) String key) {
        return new KeyValue(key, memoryStore.getValue(key));
    }
    
    public MemoryStore getMemoryStore() {
        return this.memoryStore;
    }
}