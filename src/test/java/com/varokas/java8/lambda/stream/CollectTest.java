package com.varokas.java8.lambda.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * Collect is a way java8 turns Stream back into list. I like scala approach
 * better as we are not forced to convert to collection on a reduction operation
 *
 * Luckily we have {@link java.util.stream.Collectors} for most useful stuff.
 */
public class CollectTest {
  @Test
  public void collectTestWithACollector() {
    List<Integer> integers = Arrays.asList(1,2,3);

    final Collector<Integer, ?, List<Integer>> aCollector = Collectors.toList();

    List<Integer> collectedList = integers.stream().collect(aCollector);

    assertEquals(integers, collectedList);
  }


  /**
   * Another collect method accepts a supplier, accumulator, combiner instead of a collector
   *
   * This is basically a component that made up a collector. So that we can use them
   * directly without having to construct a new collector for it.
   */
  @Test
  public void collectTestWithExplodedCollector() {
    List<Integer> integers = Arrays.asList(1, 2, 3);

    Supplier<List<Integer>> supplier = () -> new ArrayList<>();
    BiConsumer<List<Integer>, Integer> accumulator = (list, element) -> list.add(element);
    BiConsumer<List<Integer>, List<Integer>> combiner = (partialListA, partialListB) -> partialListA.addAll(partialListB);

    List<Integer> collectedList = integers.stream().collect(supplier, accumulator, combiner);

    assertEquals(integers, collectedList);
  }
}
