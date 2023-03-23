package ec.com.learning.rxjava.combiningObservables;

import io.reactivex.rxjava3.core.Observable;
import java.util.List;

/**
 *
 * @author Steven Guamán - March 2023
 */
public class FlatMapAndConcatMap {

    public static void main(String[] args) {

        List<String> list = List.of("Hello", "Reactive", "Programming");
        Observable.fromIterable(list)
                .flatMap(e -> Observable.fromArray(e.split("")))
                .toList()
                .subscribe(System.out::println);

        Observable.fromIterable(list)
                .map(e -> e.length())
                .toList()
                .subscribe(System.out::println);

        Observable.fromIterable(list)
                .concatMap(e -> Observable.fromArray(e.split("")))
                .toList()
                .subscribe(System.out::println);
    }

}
