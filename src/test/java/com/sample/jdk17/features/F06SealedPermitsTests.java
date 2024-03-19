package com.sample.jdk17.features;

import com.sample.jdk17.base.IBaseTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * F06SealedPermitsTests
 *
 * @author Aaric
 * @version 0.5.0-SNAPSHOT
 */
@Slf4j
public class F06SealedPermitsTests implements IBaseTests {

    public static sealed abstract class Animal permits Cat, Dog {
        public abstract void shout();
    }

    public static final class Cat extends Animal {
        @Override
        public void shout() {
            System.err.println("Meow");
        }
    }

    public static sealed class Dog extends Animal permits Husky {
        @Override
        public void shout() {
            System.err.println("Bow wow");
        }
    }

    public static final class Husky extends Dog {
    }

    @Test
    @Override
    public void testNow() {
        Husky husky = new Husky();
        husky.shout();
    }
}
