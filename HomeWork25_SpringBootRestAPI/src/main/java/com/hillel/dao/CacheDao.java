package com.hillel.dao;


import com.hillel.services.CacheService;
import com.hillel.services.impl.CacheServiceImpl;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Setter
@Getter
@Builder
@ToString
@Service
public class CacheDao {

    private static final Logger logger = LoggerFactory.getLogger("stdout");

    CacheService cacheService;


    /**
     * method creates cache and put data to empty cache map<String (cacheName), map<String (key), String (value)>>
     *
     * @param cacheName - cache name
     * @param key - cache key
     * @param value - cache value
     * @return - information about the result of the method execution (true / false)
     * {@link CacheServiceImpl#createCache(String)}
     * {@link CacheServiceImpl#putCache(String, String, String)}
     */
    public String putCacheDao(String cacheName, String key, String value) {
        String response;
        if (cacheService.putCache(cacheName, key, value)) {
            response = "Cache <" + cacheName + "> created!";
        } else response = "Can't create cache < " + cacheName + " >!";
        return response;
    }


    /**
     * method returns the data stored in the cache
     *
     * @param cacheName - cache name
     * @param key - cache key
     * @return - information about the result of the method execution and value of request
     * {@link CacheServiceImpl#getCacheValue(String, String)}

     */
    public String getCacheValueDao(String cacheName, String key) {
        return cacheService.getCacheValue(cacheName, key).toString();
    }


    /**
     * method clear all cache value: map<String (null), map<String (null), String (null)>>
     *
     * @return - information about the result of the method execution
     * {@link CacheServiceImpl#clearCache()}
     */
    public String clearCacheDao() {
        String result;
        cacheService.clearCache();
        if (CacheServiceImpl.getCache().isEmpty()) {
            result = "Cache has cleared!";
        } else {
            result = "Can't clear the cache!";
        }
        return result;
    }


    /**
     * method clear data of cache by cache name: map<String (cacheName), map<String (null), String (null)>>
     *
     * @param cacheName - cache name
     * @return - information about the result of the method execution
     * @throws NullPointerException if cache isn't exist
     * {@link CacheServiceImpl#clearCache(String)}
     */
    public String clearCacheDao(String cacheName) {
        String result = "No data!";
        cacheService.clearCache(cacheName);
        try{
            if (CacheServiceImpl.getCacheData().isEmpty()) {
                result = "Cache data cleared by cache name!";
            } else {
                result = "Can't clear the cache data by cache name!";
            }
        } catch (NullPointerException e) {
            System.out.println("Can't clear the cache data by cache name! Error!");
        }
        return result;

    }


    /**
     * method checks if cache exists or not
     *
     * @param cacheName - cache name
     * @return - information about the result of the method execution
     * {@link CacheServiceImpl#isCacheExist(String)}
     */
    public String isCacheExistDao(String cacheName) {
        String result;
        if (cacheService.isCacheExist(cacheName)) {
            result = "Cache < " + cacheName + " > exists!";
        } else {
            result = "Cache named -> " + cacheName + " doesn't exist!";
        } return result;
    }


}
