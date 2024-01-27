package com.mdoner.sec01;

import com.mdoner.util.Util;
import reactor.core.publisher.Mono;

public class Lec08MonoFromRunnable {

    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("runnable");
        Mono.fromRunnable(timeConsumingProcess())
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );
    }

    private static Runnable timeConsumingProcess() {
        return () -> {
            Util.sleepSeconds(3);
            System.out.println("Operation completed");
        };
    }


}
