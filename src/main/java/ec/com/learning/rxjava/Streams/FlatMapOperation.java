package ec.com.learning.rxjava.Streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Steven Guamán - May 2023
 */
public class FlatMapOperation {
    
    public static void main(String[] args) {
        
        Stream<String> a = Stream.of("Hello", "there!");
        Stream<String> b = Stream.of("Learning", "Java?");
        
        Stream<Stream<String>> of = Stream.of(a, b);
        
        Stream<String> flatMap = Stream.of(a, b)
                .flatMap(e -> e);
        
        Path p = Paths.get("C:\\Steven\\Java Workspace\\Projects\\rxjava-basics\\src\\main\\java\\ec\\com\\learning\\rxjava\\Streams\\Sherlock");
        try (Stream<String> sherlock = Files.lines(p)) {
            
            List<String> collect = sherlock
                    .flatMap(line -> Arrays.stream(line.split(" ")))
                    .collect(Collectors.toList());
            
            collect.forEach(System.out::println);
            
        } catch (IOException ex) {
            Logger.getLogger(FlatMapOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
