package com.mdoner.sec01;

import reactor.core.publisher.Mono;

public class Lec02MonoJust {
    public static void main(String[] args) {

        Mono<Integer> just = Mono.just(1);
        just.subscribe(integer -> {
            System.out.println(integer);
            integer *=250;
            System.out.println(integer);
        });
        System.out.println(just);
    }
}
