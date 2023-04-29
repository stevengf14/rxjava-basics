package ec.com.learning.rxjava.Streams;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Steven Guamán - April 2023
 */
public class FilterOperation {
    
    public static void main(String[] args) {
        
        Stream.of(34, 678, 89, 4, 52, 31, 325, 6)
                .filter(e -> e % 2 == 0)
                .forEach(e -> System.out.println(e));
        
    }
    
}
