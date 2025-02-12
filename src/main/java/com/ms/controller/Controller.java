package com.ms.controller;

import com.ms.policies.ICache;
import com.ms.policies.LFU;
import com.ms.policies.LRU;

public class Controller {
    private ICache cache;

    public void initialiseCache(int size, String policy) {
        if(policy.equals("LRU")) {
            this.cache = new LRU(size);
        } else if(policy.equals("LFU")) {
            this.cache = new LFU(size);
        }

    }

    public void putKey(String key, String value) {
        this.cache.put(key, value);
    }

    public String getKey(String key) {
        String val = (String) this.cache.get(key);
        return val == null ? "-1" : val;
    }

    public void resizeCache(int newCapacity) {
        this.cache.changeCapacity(newCapacity);
    }
//    TODO:
//    public void changePolicy(String policy) {
//
//    }


}
