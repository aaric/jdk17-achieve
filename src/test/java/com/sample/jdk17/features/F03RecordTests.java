package com.sample.jdk17.features;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * F03RecordTests
 *
 * @author Aaric, created on 2022-06-14T17:00.
 * @version 0.2.0-SNAPSHOT
 */
@Slf4j
public class F03RecordTests {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OriginPojo {
        private Integer id;
        private String name;
    }

    @Test
    public void testOrigin() {
        OriginPojo pojo = new OriginPojo(1, "aaric");
        log.info("{}", pojo);
    }

    public static record NowPojo(Integer id, String name) {
    }

    @Test
    public void testNow() {
        NowPojo pojo = new NowPojo(1, "aaric");
        log.info("{}", pojo);
    }
}
