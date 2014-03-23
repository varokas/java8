package com.varokas.java8.lambda;

import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * Test Many Possible Form of lambda
 */
public class LambaSyntaxTest {
    /**
     * Java Functional Interface is an interface with one abstract method
     */
    interface MyFunction<T,R> {
        R aMethod(T input);
    }

    MyFunction<Integer, Integer> squareFuncAnonymous = new MyFunction<Integer, Integer>() {
        @Override
        public Integer aMethod(final Integer input) {
            return input * input;
        }
    };
    MyFunction<Integer, Integer> squareFuncLambda = (x) -> { return x * x; };
    MyFunction<Integer, Integer> squareFuncLambdaTyped = (Integer x) -> { return x * x; };
    MyFunction<Integer, Integer> squareFuncLambdaShort = (x) -> x * x;
    MyFunction<Integer, Integer> squareFuncLambdaNoParenthesis = x -> x * x;

    @Test
    public void testAllDefinitionReturnsSameResult() {
        Integer input = RandomUtils.nextInt();
        Integer result = input * input;

        Stream.of(
                squareFuncAnonymous,
                squareFuncLambda,
                squareFuncLambdaTyped,
                squareFuncLambdaShort,
                squareFuncLambdaNoParenthesis
        ).forEach(
                f -> assertEquals(result, f.aMethod(input))
        );
    }
}
