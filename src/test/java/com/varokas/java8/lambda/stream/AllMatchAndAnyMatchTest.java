package com.varokas.java8.lambda.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class AllMatchAndAnyMatchTest {
    @Test
    public void allMatchShouldBeTrueWhenAllIsMatched() throws Exception {
        List<Integer> nonZeros = Arrays.asList(1,2,3);

        assertTrue(nonZeros.stream().allMatch(i -> i > 0));
    }

    @Test
    public void allMatchShouldBeFalseWhenNotAllIsMatched() throws Exception {
        List<Integer> nonZeros = Arrays.asList(1,2,3);

        assertFalse(nonZeros.stream().allMatch(i -> i == 2));
    }

    @Test
    public void allMatchShouldBeTrueWhenStreamIsEmpty() throws Exception {
        List<Integer> emptyList = Arrays.asList();

        assertTrue( emptyList.stream().allMatch( i -> true) );
        assertTrue( emptyList.stream().allMatch(i -> false) );
    }

    @Test
    public void anyMatchShouldBeTrueWhenAtLeastOneIsMatched() throws Exception {
        List<Integer> nonZeros = Arrays.asList(1,2,3);

        assertTrue(nonZeros.stream().anyMatch(i -> i == 2));
    }

    @Test
    public void anyMatchShouldBeFalseWhenAllIsNotMatched() throws Exception {
        List<Integer> nonZeros = Arrays.asList(1,2,3);

        assertFalse( nonZeros.stream().anyMatch(i -> i < 0) );
    }

    @Test
    public void anyMatchShouldBeFalseWhenStreamIsEmpty() throws Exception {
        List<Integer> emptyList = Arrays.asList();

        assertFalse(emptyList.stream().anyMatch(i -> true));
        assertFalse(emptyList.stream().anyMatch(i -> false));
    }


}
