package com.sample.cache;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * CaffeineTests
 *
 * @author Aaric
 * @version 0.7.0-SNAPSHOT
 */
@Slf4j
public class CaffeineTests {

    public CompletableFuture<Object> setValue(String key) {
        return CompletableFuture.supplyAsync(() -> {
            return key + ":value";
        });
    }

    public Object syncCache(String key) {
        LoadingCache<String, Object> cache = Caffeine.newBuilder()
                .maximumSize(100)
                .expireAfterWrite(1, TimeUnit.MINUTES)
                .build(k -> setValue(key).get());
        return cache.get(key);
    }

    @Test
    public void testSyncCache() {
        Object obj = syncCache("key");
        System.err.println(obj);
    }
}
