package com.hillel;

import com.hillel.services.CacheService;
import com.hillel.services.impl.CacheServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Serhii Nikonenko
 * @version 1.0.0
 */

/**
 * Написать кеш с операциями: (Spring boot + rest):
 * 1. Создать кеш:
 * 2. Положить в кеш- boolean put(String cache, String key, Object o)
 * 3. Достать - Object get (String cache, String key)
 * 4. Очистить все кеши - void clear();
 * 5. Очистить кеш - void clear(string cache)
 * 6. Проверка наличие кеша void isCacheExist(String cache)
 * + JavaDocs, Логирование.
 */

@EnableSwagger2
@SpringBootApplication
public class Application {
	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);


//		CacheService cs = new CacheServiceImpl();
//
//		System.out.print("PUT -> ");
//
//		cs.putCache("MyCache", "CacheKey", "CacheValue");
//
//		System.out.print("EXIST ->  ");
//
//		cs.isCacheExist("MyCache");
//
//		System.out.print("GET -> ");
//
//		System.out.println(cs.getCacheValue("MyCache", "CacheKey"));
//
//		System.out.print("CLEAR BY NANE -> ");
//
//		cs.clearCache("MyCache");
//
//		System.out.print("GET AGAIN -> ");
//
//		System.out.println(cs.getCacheValue("MyCache", "CacheKe"));





	}
}
