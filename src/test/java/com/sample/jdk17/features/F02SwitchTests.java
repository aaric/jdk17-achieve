package com.sample.jdk17.features;

import com.sample.jdk17.base.IBaseTests;
import org.junit.jupiter.api.Test;

/**
 * F02: Switch expressions
 *
 * @author Aaric, created on 2021-10-20T17:55.
 * @version 0.2.0-SNAPSHOT
 */
public class F02SwitchTests implements IBaseTests {

    @Test
    @Override
    public void testOrigin() {
        Object id = Integer.valueOf("100");

        if (id instanceof Integer idNum) {
            System.err.println(idNum);
        } else if (id instanceof String idStr) {
            System.err.println(idStr);
        }
    }

    @Test
    @Override
    public void testNow() {
        int id = Integer.parseInt("2");
        switch (id) {
            case 1 -> System.err.println("One");
            case 2 -> System.err.println("Two");
            default -> System.err.println();
        }

        Object idx = "id";
        var result = switch (idx) {
            case Integer idNum -> idNum + idNum;
            case Double idDouble -> idDouble + idDouble;
            case null -> 0;
            default -> throw new RuntimeException("Unknown type");
        };
        System.err.println(result);
    }
}
