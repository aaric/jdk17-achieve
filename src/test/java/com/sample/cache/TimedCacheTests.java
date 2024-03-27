package com.sample.cache;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.TimedCache;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * TimedCacheTests
 *
 * @author Aaric
 * @version 0.7.0-SNAPSHOT
 */
@Slf4j
public class TimedCacheTests {

    @Test
    public void testCache() {
        TimedCache<String, String> timedCache = CacheUtil.newTimedCache(15);
        timedCache.put("key1", "value1");
        timedCache.put("key2", "value2", 5);
        timedCache.put("key3", "value3", DateUnit.SECOND.getMillis() * 5);

        ThreadUtil.sleep(10);

        System.err.println(timedCache.get("key1"));
        System.err.println(timedCache.get("key2"));
        System.err.println(timedCache.get("key3"));

        timedCache.cancelPruneSchedule();
    }
}
