package com.hillel.services.impl;

import com.hillel.services.CacheService;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CacheServiceImpl implements CacheService {

    private static final Logger logger = LoggerFactory.getLogger("stdout");


    @Getter
    private static Map<String, Map<String, String>> cache;
    @Getter
    private static Map<String, String> cacheData = new HashMap<>();


    /**
     * method create empty cache map<String (cacheName), map<String, String>>
     *
     * @param cacheName - cache name
     */
    @Override
    public void createCache(String cacheName) {
        try {
            cache = new HashMap<>();
            cache.put(cacheName, cacheData);
        } catch (NullPointerException e) {
            logger.info("Cache creating ERROR!");
        }
    }


    /**
     * method put data to empty cache map<String (cacheName), map<String (key), String (value)>>
     *
     * @param cacheName - cache name
     * @param key - cache key
     * @param value - cache value
     * @return - information about the result of the method execution (true / false)
     */
    @Override
    public boolean putCache(String cacheName, String key, String value) {
        boolean result = false;
        try {
            if (cache == null) {
                createCache(cacheName);
                cacheData.put(key, value);
                cache.put(cacheName, cacheData);
                logger.info("Created new cache: " + cache);
                result = true;
            } else if (cache.containsKey(cacheName)) {
                cacheData.put(key, value);
            }
        } catch (Exception e) {
            logger.info("Can't put data to cache!");
        }
        return result;
    }


    /**
     * method returns the data stored in the cache
     *
     * @param cacheName - cache name
     * @param key - cache key
     * @return - information about the result of the method execution and value of request
     */
    @Override
    public String getCacheValue(String cacheName, String key) {
        String result = "No data!";
        try {
            logger.info("Success -> " + cache.get(cacheName).get(key));
            result = cache.get(cacheName).get(key);
        } catch (Exception e) {
            result = "There’s no data here!";
            logger.info("Can't get data from cache < " + cacheName + " > by key < " + key + " >");
        } finally {
            return result;
        }
    }


    /**
     * method clear all cache value: map<String (null), map<String (null), String (null)>>
     * @throws NullPointerException if cache isn't exist
     */
    @Override
    public void clearCache() {
        try {
            cache.clear();
            logger.info("Cache has totally cleared!");
        } catch (NullPointerException e) {
            logger.info("Can't clear cache!");
        }
    }


    /**
     * method clear data of cache by cache name: map<String (cacheName), map<String (null), String (null)>>
     *
     * @param cacheName - cache name
     * @throws NullPointerException if cache isn't exist
     */
    @Override
    public void clearCache(String cacheName) {
        try {
            cacheData = cache.get(cacheName);
            if (cacheData != null) {
                cacheData.clear();
                cache = null;
                logger.info("Cache " + cacheName + " cleared!");
            }
        } catch (Exception e) {
            logger.info("Can't clear cache -> " + cacheName);
        }
    }


    /**
     * method checks if cache exists or not
     *
     * @param cacheName - cache name
     * @return - information about the result of the method execution (Exist -> true / No -> false)
     */
    @Override
    public boolean isCacheExist(String cacheName) {
        boolean isExist = false;
        try {
            if (cache.containsKey(cacheName)) {
                isExist = true;
                logger.info("Cache < " + cacheName + " > exists!");
                System.out.println(cache.toString());
            }
        } catch (Exception e) {
            logger.info("Cache named -> " + cacheName + " doesn't exist!");
        } finally {
            return isExist;
        }
    }
}
