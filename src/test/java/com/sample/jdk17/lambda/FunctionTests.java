package com.sample.jdk17.lambda;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.function.*;
import java.util.stream.Stream;

/**
 * FunctionTests
 *
 * @author Aaric
 * @version 0.8.0-SNAPSHOT
 */
@Slf4j
public class FunctionTests {

    @Test
    public void testFunction() {
        Supplier<String> supplier = () -> "Hello World!";
        log.info(supplier.get());

        Consumer<String> consumer = (str) -> log.info(str);
        consumer.accept("Hello World!");

        Function<Integer, Integer> function = i -> i * i;
        log.info("{}", function.apply(2));

        UnaryOperator<Integer> unaryOperator = i -> i * i;
        log.info("{}", unaryOperator.apply(2));

        BiFunction<Integer, Integer, Integer> biFunction = (i, j) -> i * j;
        log.info("{}", biFunction.apply(2, 3));
    }
}
