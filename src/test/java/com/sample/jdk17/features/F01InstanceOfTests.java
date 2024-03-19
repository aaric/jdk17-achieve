package com.sample.jdk17.features;

import com.sample.jdk17.base.IBaseTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * F01: Pattern matching for instanceof
 *
 * @author Aaric, created on 2021-10-20T16:46.
 * @version 0.2.0-SNAPSHOT
 */
@Slf4j
public class F01InstanceOfTests implements IBaseTests {

    @Test
    @Override
    public void testOrigin() {
        Object obj = "hello world";
        if (obj instanceof String) {
            String str = (String) obj;
            log.info("str -> {}", str);
        }
    }

    @Test
    @Override
    public void testNow() {
        Object obj = "hello world";
        if (obj instanceof String str) {
            log.info("str -> {}", str);
        }
    }
}
