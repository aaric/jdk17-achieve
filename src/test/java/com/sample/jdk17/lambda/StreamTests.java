package com.sample.jdk17.lambda;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

/**
 * StreamTests
 *
 * @author Aaric
 * @version 0.8.0-SNAPSHOT
 */
@Slf4j
public class StreamTests {

    @Test
    public void testStream() {
        String[] arr = {"hello", "world"};
        Arrays.stream(arr).forEach(System.err::println);
        Arrays.asList(arr).forEach(System.err::println);
        Stream.of(arr).forEach(System.err::println);
        Stream.iterate(1, i -> i + 1).limit(10).forEach(System.err::println);
        Stream.generate(() -> new Random().nextInt(10)).limit(10).forEach(System.err::println);
    }
}
