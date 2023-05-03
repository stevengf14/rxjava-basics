package ec.com.learning.rxjava.Streams;

import java.util.stream.Stream;

/**
 *
 * @author Steven Guamán - April 2023
 */
public class ReduceOperation {

    public static void main(String[] args) {

        Integer sum = Stream.of(1, 2, 34, 56, 76, 87, 89, 90)
                .reduce(0, (a, b) -> a + b);

        // 0+9=9 sun
        // 1*8=0 multiplication
        System.out.println(sum);

    }

}
