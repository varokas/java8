package com.t2decode.java.eight;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static junit.framework.Assert.assertEquals;


/**
 * From: http://iporsut.blogspot.com/2014/03/l-99-p09-java-lambda.html
 */
public class AppTest {

    public List<List<Character>> pack(List<Character> input) {
        List<List<Character>> result = new ArrayList<>();

        input.stream()
                .collect(Collectors.groupingBy(
                        a -> a
                ))
                .forEach(
                        (key, values) -> {
                            result.add(values);
                        }
                );

        return result;
    }


    @Test
    public void spikeLambdaMap() {
        List<Character> input = Arrays.asList('a','a','a','a','a','b','c','c','d','e','e','e','e');

        List<List<Character>> expect = new ArrayList<>();
        expect.add(Arrays.asList('a','a','a','a','a'));
        expect.add(Arrays.asList('b'));
        expect.add(Arrays.asList('c','c'));
        expect.add(Arrays.asList('d'));
        expect.add(Arrays.asList('e','e','e','e'));

        assertEquals(expect, pack(input));
    }

    @Test
    public void spikeLambdaMapWithDuplicateEntriesInOtherPosition() {
        List<Character> input = charList("a a a a b c c a a d e e e e");

        List<List<Character>> expect = Arrays.asList(
            charList("a a a a"),
            charList("b"),
            charList("c c"),
            charList("a a"),
            charList("d"),
            charList("e e e e")
        );

        assertEquals(expect, pack(input));
    }

    private List<Character> charList(String str) {
        List<String> tokens = Arrays.asList(str.split("\\s"));
        List<Character> inputList = new ArrayList<>();
        for (String token : tokens) {
            inputList.add(token.charAt(0));
        }
        return inputList;
    }
}
