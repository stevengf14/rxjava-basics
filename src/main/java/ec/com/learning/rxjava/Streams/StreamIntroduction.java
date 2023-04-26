package ec.com.learning.rxjava.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Steven Guamán - April 2023
 */
public class StreamIntroduction {
    
    public static void main(String[] args) {
        
        List<Book> books = new ArrayList<>();

        // before java 8
        List<Book> popularHorrorBooks = new ArrayList<>();
        
        for (Book book : books) {
            if (book.getGenre().equalsIgnoreCase("Horror") && book.getRating() > 3) {
                popularHorrorBooks.add(book);
            }
        }

        // after java 8
        List<Book> collect = books.parallelStream()
                .filter((book) -> book.getGenre().equalsIgnoreCase("Horror"))
                .filter((book) -> book.getRating() > 3)
                .collect(Collectors.toList());
    }
    
}
