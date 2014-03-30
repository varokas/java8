package com.varokas.java8.lambda.stream;

import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class StaticMethodsTest {
  @Test
  public void ofShouldConstructStream() throws Exception {
    Stream<Integer> streamFromValue = Stream.of(1);
    Stream<Integer> streamFromVarArgs = Stream.of(1, 2);

    assertStreamValue(new Integer[]{1}, streamFromValue);
    assertStreamValue(new Integer[]{1, 2}, streamFromVarArgs);
  }

  @Test
  public void concatShouldReturnsCombinedStream() throws Exception {
    Stream<Integer> streamA = Stream.of(1,2);
    Stream<Integer> streamB = Stream.of(3,4);

    final Stream<Integer> concatStream = Stream.concat(streamA, streamB);

    assertStreamValue(new Integer[]{1, 2, 3, 4}, concatStream);
  }

  @Test
  public void emptyReturnsEmptyStream() throws Exception {
    assertStreamValue(new Integer[]{}, Stream.empty());
  }

  /**
   * Generate stream from a supplier, the resulting stream
   * would always be an infinite stream, so be careful!
   */
  @Test
  public void streamGenerateFromSupplier() throws Exception {
    Supplier<Integer> constantSupplier = () -> 1;

    //This will runs in an infinite loop!
    //assertStreamValue( new Integer[] {1, 1},  Stream.generate(constantSupplier) );

    assertStreamValue( new Integer[] {1, 1},  Stream.generate(constantSupplier).limit(2) );
  }

  /**
   * Again, an infinite stream generator, be careful to trim them
   * before calling the collectors!
   */
  @Test
  public void streamIterate() throws Exception {
    Stream<Integer> increasingList = Stream.iterate(1, last -> last+1);

    assertStreamValue( new Integer[] {1, 2, 3, 4, 5},  increasingList.limit(5) );
  }

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


  private <T> void assertStreamValue(final T[] values, final Stream<T> stream) {
    assertEquals(toList(values), toList(stream));
  }

  private <T> List<T> toList(T... elements) {
    return Arrays.asList(elements);
  }

  private <T> List<T> toList(final Stream<T> stream) {
    return stream.collect(Collectors.toList());
  }
}
