package com.mdoner.sec01;

import com.mdoner.sec01.assignment.FileService;
import com.mdoner.util.Util;

public class Lec09Assignment {

    public static void main(String[] args) {
        FileService.read("file1.txt")
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );

        FileService.write("file3.txt" ,"asdasfasf")
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );


    }
}
