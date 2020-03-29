package com.mwaseem.fp.collections;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.function.Function;

/**
 * Created by mohd.waseem on 29/03/20.
 */
public class CollectionsExample {
    final static String[] food = new String[] {
            "Kachchi bhindi",
            "Aunty k oats",
            "Pani wali chai",
            "chipki hui maggi"
    };

    private static Function<String, String> lastWordOf = phrase -> {
        String[] words = phrase.split(" ");
        return words[words.length-1];
    };

    private static String summarize(final String[] descriptions) {
        return Arrays.stream(descriptions)
                .peek(s-> System.out.println("About to filter: " + s))
                .filter(StringUtils::isNotBlank)
                .peek(s-> System.out.println("About to map: " + s))
                .map(lastWordOf)
                .peek(s-> System.out.println("About to reduce: " + s))
                .reduce(joinOn(" & "))
                .orElse("");
    }

    private static BinaryOperator<String> joinOn(String connector) {
        return (allSoFar, nextElement) -> allSoFar + connector + nextElement;
    }

    public static void main(String[] args) {
        System.out.println(summarize(food));
        System.out.println(summarize(new String[]{null}));
    }
}
