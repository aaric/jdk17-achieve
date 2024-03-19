package com.sample.jdk17.features;

import com.sample.jdk17.base.IBaseTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * F05DateTimeFormatterTests
 *
 * @author Aaric
 * @version 0.5.0-SNAPSHOT
 */
@Slf4j
public class F05DateTimeFormatterTests implements IBaseTests {

    @Test
    public void testOrigin() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.info("{}", format.format(Date.from(Instant.now())));
    }

    @Test
    public void testNow() {
        log.info("{}", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()));
    }
}
