package ec.com.learning.rxjava.Streams;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author Steven Guamán - May 2023
 */
public class InfiniteStreams {

    public static void main(String[] args) {

        Stream.iterate(0, i -> i + 1)
                .limit(10)
                .forEach(System.out::println);

        IntStream.iterate(100, i -> i - 1)
                .limit(10)
                .forEach(System.out::println);

        Stream.generate(new Random()::nextInt)
                .limit(10)
                .forEach(System.out::println);

    }

}
