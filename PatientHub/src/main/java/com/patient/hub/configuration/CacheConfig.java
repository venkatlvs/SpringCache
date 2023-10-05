package com.patient.hub.configuration;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {

	@Bean
	public ConcurrentMapCacheManager cacheManager() {
		System.out.println("===========cached============");
		return new ConcurrentMapCacheManager("patients");
	}
}
