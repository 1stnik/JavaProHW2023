package com.hillel.services;

public interface CacheService {

    void createCache(String cacheName);

    boolean putCache(String cacheName, String key, String value);

    Object getCacheValue(String cacheName, String key);

    void clearCache();

    void clearCache(String cacheName);

    boolean isCacheExist(String cacheName);




}
