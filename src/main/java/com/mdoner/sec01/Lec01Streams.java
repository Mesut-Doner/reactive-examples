package com.mdoner.sec01;

import java.util.stream.Stream;

public class Lec01Streams {
    public static void main(String[] args) {
        Stream<Integer> s1 = Stream.of(1)
                .map(i -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return i * 2;
                });
        System.out.println(s1);
        System.out.println(s1.toString());
        s1.forEach(System.out::println);
    }

}