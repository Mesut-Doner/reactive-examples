package com.mdoner.sec01.assignment;

import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {

    private static final Path ASSIGNMENT_PATH = Paths.get("src/main/resources/assignment/sec01");


    public static Mono<String> read(String fileName) {
        return Mono.fromSupplier(() -> readFile(fileName));
    }

    public static Mono<Void> write(String fileName, String content) {
        return Mono.fromRunnable(() -> writeFile(fileName,content));
    }

    public static Mono<Void> delete(String fileName) {
        return Mono.fromRunnable(() -> deleteFile(fileName));
    }
    private static String readFile(String filename) {
        try {
            return Files.readString(ASSIGNMENT_PATH.resolve(filename));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeFile(String filename, String content) {
        try {
            Files.writeString(ASSIGNMENT_PATH.resolve(filename), content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void deleteFile(String filename) {
        try {
            Files.delete(ASSIGNMENT_PATH.resolve(filename));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
