package ec.com.learning.rxjava.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author steve
 */
public class ObservingTheStream {

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();

        // before java 8
        List<Book> popularHorrorBooks = books.stream()
                .filter((book) -> book.getGenre().equalsIgnoreCase("Horror"))
                .filter((book) -> book.getRating() > 3)
                .collect(Collectors.toList());

        // 1.
        Stream<Book> stream = books.stream();

        // 2.
        Stream<Book> horrorBooks = stream.filter((book) -> book.getGenre().equalsIgnoreCase(("Horror")));

        // 3.
        Stream<Book> pHorrorBooks = horrorBooks.filter((book) -> book.getRating() > 3);

        // 4.
        List<Book> collect = pHorrorBooks.collect(Collectors.toList());
    }

}
