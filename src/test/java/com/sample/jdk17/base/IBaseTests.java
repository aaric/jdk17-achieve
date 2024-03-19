package com.sample.jdk17.base;

/**
 * BaseTests
 *
 * @author Aaric
 * @version 0.5.0-SNAPSHOT
 */
public interface IBaseTests {

    default void testOrigin() {
        throw new UnsupportedOperationException("testOrigin");
    }

    void testNow();
}
