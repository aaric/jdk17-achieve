package com.sample.jdk17.features;

import com.sample.jdk17.base.IBaseTests;

/**
 * com.sample.jdk17.features
 *
 * @author Aaric
 * @version 0.6.0-SNAPSHOT
 */
public class F08SnippetTests implements IBaseTests {

    /**
     * {@snippet lang = java:
     *    System.err.println("hello world");
     * }
     */
    @Override
    public void testNow() {
        System.err.println("hello world");
    }
}
