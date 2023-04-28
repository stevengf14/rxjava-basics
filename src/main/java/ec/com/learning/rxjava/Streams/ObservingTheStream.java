package ec.com.learning.rxjava.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Steven Guamán - April 2023
 */
public class ObservingTheStream {

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();

        // Stream the pipeline
        List<Book> popularHorrorBooks = books.stream() // Source
                .filter((book) -> book.getGenre().equalsIgnoreCase("Horror")) // Intermediate Operation
                .filter((book) -> book.getRating() > 3) // Intermediate Operation
                .collect(Collectors.toList()); // Terminal Operation

        // 1.
        Stream<Book> stream = books.stream(); // Source

        // 2. Intermediate Operation
        Stream<Book> horrorBooks = stream.filter((book) -> book.getGenre().equalsIgnoreCase(("Horror")));

        // 3. Intermediate Operation
        Stream<Book> pHorrorBooks = horrorBooks.filter((book) -> book.getRating() > 3);

        // 4. Terminal Operation
        List<Book> collect = pHorrorBooks.collect(Collectors.toList());
    }

}
