package com.hillel.controller;

import com.hillel.dao.CacheDao;
import com.hillel.services.impl.CacheServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.0.1
 */
@RestController
@RequestMapping("/api")
//@RequiredArgsConstructor
public class CacheController {

    private static final Logger logger = LoggerFactory.getLogger("stdout");

    private static final String CALL_ENDPOINT = "call endpoint : %s ";
    private final CacheServiceImpl cs;

    private final CacheDao cd;

    @Autowired
    public CacheController(CacheServiceImpl cs, CacheDao cd) {
        this.cs = cs;
        this.cd = cd;
    }


    @GetMapping("/ping")
    public String ping() {
        logger.info(String.format(CALL_ENDPOINT, "ping"));
        return "work - OK";
    }

    @PostMapping("/put")
    public String putCache(@RequestParam String cacheName,
                            @RequestParam String key,
                            @RequestParam String value) {
        logger.info(String.format(CALL_ENDPOINT, "put"));
        return cd.putCacheDao(cacheName, key, value);
    }


    @GetMapping("/get")
    public String getCacheValue(@RequestParam String cacheName, @RequestParam String key) {
        logger.info(String.format(CALL_ENDPOINT, "get"));
        return cd.getCacheValueDao(cacheName, key);
    }

    @DeleteMapping("/clear")
    public String clearCache() {
        logger.info(String.format(CALL_ENDPOINT, "clear"));
        return cd.clearCacheDao();
    }

    @DeleteMapping("/clear/{cacheName}")
    public String clearCache(@PathVariable String cacheName) {
        logger.info(String.format(CALL_ENDPOINT, "clearByName"));
        return cd.clearCacheDao(cacheName);
    }

    @GetMapping("/isCacheExist")
    public String isCacheExist(@RequestParam String cacheName) {
        logger.info(String.format(CALL_ENDPOINT, "isCacheExist"));
        return cd.isCacheExistDao(cacheName);
    }
}
