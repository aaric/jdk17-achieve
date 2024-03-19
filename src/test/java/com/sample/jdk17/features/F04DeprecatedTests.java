package com.sample.jdk17.features;

import com.sample.jdk17.base.IBaseTests;

/**
 * F04DeprecatedTests
 *
 * @author Aaric
 * @version 0.5.0-SNAPSHOT
 */
public class F04DeprecatedTests implements IBaseTests {

    @Override
    public void testNow() {
        @Deprecated(since = "0.4.0-SNAPSHOT")
        String num = "N001";

        @Deprecated(since = "0.4.0-SNAPSHOT", forRemoval = true)
        String name = "Aaric";
    }
}
