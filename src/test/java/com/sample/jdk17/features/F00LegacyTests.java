package com.sample.jdk17.features;

import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * F00LegacyTests
 *
 * @author Aaric, created on 2022-05-20T17:55.
 * @version 0.2.0-SNAPSHOT
 */
@Slf4j
public class F00LegacyTests {

    @Data
    @Accessors(chain = true)
    public static class Stu {
        private String name;
        private Integer age;
    }

    @Test
    public void testLegacy() {
        Assertions.assertDoesNotThrow(() -> {
            Stu s1 = new Stu()
                    .setName("zhangsan")
                    .setAge(18);
            Stu s2 = new Stu();

            BeanUtils.copyProperties(s2, s1);

            log.info("{}", s2);
        });
    }
}
