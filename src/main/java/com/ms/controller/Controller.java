package com.ms.controller;

import com.ms.policies.ICache;
import com.ms.policies.LRU;

public class Controller {
    private ICache cache;

    public void initialiseCache(int size, String policy) {
        if(policy.equals("LRU")) {
            this.cache = new LRU(size);
        }
    }

    public void putKey(String key, String value) {
        this.cache.put(key, value);
    }

    public String getKey(String key) {
        String val = (String) this.cache.get(key);
        return val == null ? "-1" : val;
    }

//    public void resizeCache(int size) {
//        this.cache.changeCapacity(size);
//    }
//    TODO:
//    public void changePolicy(String policy) {
//
//    }


}
