package com.sample.jdk17.features;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * F02: Switch expressions
 *
 * @author Aaric, created on 2021-10-20T17:55.
 * @version 0.2.0-SNAPSHOT
 */
public class F02SwitchTests {

    private static final String KEY_ID = "ID";
    private static final String KEY_NAME = "NAME";

    private static Map<String, Object> dataMap;

    @BeforeAll
    public static void setUp() {
        dataMap = new HashMap<>();
        dataMap.put(KEY_ID, 1);
        dataMap.put(KEY_NAME, "Aaric");
    }

    @Test
    public void testOrigin() {
        Map<String, Object> dataMap = new HashMap<>();

        if(dataMap.get(KEY_ID) instanceof Integer id){
            System.err.println(id);
        } else if (dataMap.get(KEY_NAME) instanceof String name) {
            System.err.println(name);
        }
    }

    @Test
    public void testNow() {
        switch (dataMap.get(KEY_ID)) {
            case Integer i -> System.err.println(i);
            case Double d -> System.err.println(d);
            default -> System.err.println();
        }
    }
}
