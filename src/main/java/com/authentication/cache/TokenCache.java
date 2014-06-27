package com.authentication.cache;

import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class TokenCache {

    private Cache<String, Integer> cache;

    public TokenCache() {
        cache = CacheBuilder.newBuilder().expireAfterWrite(4, TimeUnit.HOURS).build();
    }

    public void put(String key, int value) {
        cache.put(key, value);
    }

    public Integer get(String key) {
        int value = 0;
        try {
            value = cache.getIfPresent(key);
        } catch (Exception e) {
        }
        return value;
    }
}
