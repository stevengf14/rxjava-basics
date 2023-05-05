package ec.com.learning.rxjava.Streams;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 *
 * @author Steven Guamán - May 2023
 */
public class Calculations {

    public static void main(String[] args) {

        //IntStream
        //DoubleStream
        //LongStream
        
        //Sum
        int sum = IntStream.of(1, 2, 3)
                .sum();
        System.out.println("sum: " + sum);

        //max(): Optional Primitive
        OptionalInt maxOptional = IntStream.of(1, 2, 3)
                .max();
        System.out.println("max: " + maxOptional.getAsInt());

        //min(): Optional Primitive
        OptionalInt minOptional = IntStream.of(1, 2, 3)
                .min();
        System.out.println("min: " + minOptional.getAsInt());

        //average(): OptionalDouble
        OptionalDouble avgOptional = IntStream.of(1, 2, 3)
                .average();
        System.out.println("average: " + avgOptional.getAsDouble());

        //sumaryStatistics()
        IntSummaryStatistics summaryStatistics = IntStream.of(1, 2, 3)
                .summaryStatistics();
        System.out.println("summaryStatistics: " + summaryStatistics);
    }

}
