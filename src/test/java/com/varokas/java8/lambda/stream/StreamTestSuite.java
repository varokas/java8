package com.varokas.java8.lambda.stream;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Explore Stream interface.
 * http://download.java.net/jdk8/docs/api/java/util/stream/Stream.html
 *
 * @see java.util.stream.Stream
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        AllMatchAndAnyMatchTest.class,
        BuilderTest.class,
})
public class StreamTestSuite {
}
