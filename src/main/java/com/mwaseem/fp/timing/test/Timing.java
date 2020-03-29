package com.mwaseem.fp.timing.test;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by mohd.waseem on 29/03/20.
 */
public class Timing {

    public static <T> T timed(String description, Supplier<T> code) {
//        Consumer<String> console = System.out::println;
        Consumer<String> console = (s) -> {};
        return timed(description, code, console);

    }

    public static <T> T timed(String description, Supplier<T> code, Consumer<String> output) {
        final long start = System.currentTimeMillis();
        T result = code.get();
        output.accept( description + " took " + (System.currentTimeMillis() - start) + " millis");
        return result;
    }
}
