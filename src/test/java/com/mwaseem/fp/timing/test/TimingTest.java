package com.mwaseem.fp.timing.test;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

public class TimingTest {

    @Test
    public void timed() {
        final String description = "Supply Carrot";
        AtomicReference<String> output = new AtomicReference<>("");
        Timing.timed(description, ()-> "Carrot", output::set);
        assert(output.get().contains(description));
    }
}