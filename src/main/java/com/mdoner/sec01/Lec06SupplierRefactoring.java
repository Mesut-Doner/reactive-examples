package com.mdoner.sec01;

import com.mdoner.util.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Lec06SupplierRefactoring {


    public static void main(String[] args) {
        getName();
        getName()
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(
                Util.onNext()
        );
        getName();

        Util.sleepSeconds(4);
    }

    private static Mono<String> getName() {
        System.out.println("Entered get name method");
        return Mono.fromSupplier(() -> {
            System.out.println("Generating name...");
            Util.sleepSeconds(3);
            return Util.getFaker().name().fullName();
        }).map(String::toUpperCase);
    }
}
