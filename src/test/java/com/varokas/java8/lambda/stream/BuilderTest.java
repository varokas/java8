package com.varokas.java8.lambda.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class BuilderTest {
    @Test
    public void builderShouldReturnAStreamBuilder() throws Exception {
        Stream<Integer> stream =
                Stream.<Integer>builder()
                        .add(1)
                        .add(2)
                        .build();

        List<Integer> resultList = toList(stream);

        assertEquals(Arrays.asList(1, 2), resultList);
    }

    private List<Integer> toList(final Stream<Integer> stream) {
        return stream.collect(Collectors.toList());
    }
}
