package com.mdoner.sec01;

import com.mdoner.util.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Lec05MonoFromSupplier {
    public static void main(String[] args) {

        Mono<String> mono = Mono.just(getName());
        Mono<String> mono2 = Mono.fromSupplier(Lec05MonoFromSupplier::getName);

        mono2.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );

        Supplier<String> supplier = () -> getName();
        Callable<String> callable = () -> getName();
        Mono.fromSupplier(supplier)
                .subscribe(
                        Util.onNext()
                );
        Mono.fromCallable(callable)
                .subscribe(
                        Util.onNext()
                );


    }
    private static String getName() {
        System.out.println("Generating name");
        return Util.getFaker().name().fullName();
    }
}
