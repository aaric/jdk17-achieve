package com.sample.jdk17.features;

import org.junit.jupiter.api.Test;

/**
 * F02: Switch expressions
 *
 * @author Aaric, created on 2021-10-20T17:55.
 * @version 0.2.0-SNAPSHOT
 */
public class F02SwitchTests {

    @Test
    public void testOrigin() {
        Object id = "id";

        if (id instanceof Integer idNum) {
            System.err.println(idNum);
        } else if (id instanceof String idStr) {
            System.err.println(idStr);
        }
    }

    @Test
    public void testNow() {
        Object id = "id";

        switch (id) {
            case Integer idNum -> System.err.println(idNum);
            case Double idStr -> System.err.println(idStr);
            default -> System.err.println();
        }
    }
}
