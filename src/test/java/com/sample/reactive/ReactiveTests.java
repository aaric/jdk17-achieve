package com.sample.reactive;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * ReactiveTests
 *
 * @author Aaric
 * @version 0.8.0-SNAPSHOT
 */
public class ReactiveTests {

    @SneakyThrows
    @Test
    public void testReactivePubSub() {
        // 创建发布者
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();

        // 创建订阅者
        Flow.Subscriber<String> subscriber = new Flow.Subscriber<>() {

            private Flow.Subscription subscription;

            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                System.err.println("onSubscribe");
                this.subscription = subscription;
                this.subscription.request(1);
            }

            @Override
            public void onNext(String item) {
                System.err.println("onNext: " + item);
                this.subscription.request(10);
            }

            @Override
            public void onError(Throwable throwable) {
                System.err.println("onError");
            }

            @Override
            public void onComplete() {
                System.err.println("onComplete");
            }
        };

        // 建立订阅者
        publisher.subscribe(subscriber);

        // 发送数据
        for (int i = 0; i < 10; i++) {
            publisher.submit("Hello Reactive Streams");
        }

        TimeUnit.SECONDS.sleep(10);
        publisher.close();
    }

    @SneakyThrows
    @Test
    public void testReactiveMono() {
        Mono.empty().subscribe(System.err::println);
        Mono.just("Hello Reactive Streams").subscribe(System.err::println);
    }

    @SneakyThrows
    @Test
    public void testReactiveFlux() {
        Flux.just(1, 2, 3, 4, 5).subscribe(System.err::println);
        Flux.fromIterable(Arrays.asList(1, 2, 3, 4, 5)).subscribe(System.err::println);
        Flux.fromArray(new Integer[]{1, 2, 3, 4, 5}).subscribe(System.err::println);
        Flux.fromStream(Stream.of(1, 2, 3, 4, 5)).subscribe(System.err::println);
        Flux.range(1, 5).subscribe(System.err::println);
        Flux.generate(() -> 0, (i, sink) -> {
                    sink.next("2*" + i + "=" + 2 * i);
                    if (i == 9) sink.complete();
                    return i + 1;
                })
                .subscribe(System.err::println);
    }
}
