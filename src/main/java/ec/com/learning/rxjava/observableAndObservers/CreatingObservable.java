package ec.com.learning.rxjava.observableAndObservers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Steven Guamán - March 2023
 */
public class CreatingObservable {

    public static void main(String args[]) throws InterruptedException {

        // create
        create();

        // just
        just();

        // fromIterable
        fromIterable();

        // range
        range();

        // interval
        interval();

        // future
        // Observable.future(future)
        
        // empty
        Observable.empty();

        // never
        Observable.never();

        // error
        // Observable.error(exception);
        
        // defer
        defer();
        
        // fromCallable
        //Observable.fromCallable(Callable);
        
    }

    public static void create() {
        Observable<Integer> source = Observable.create(
                e -> {
                    e.onNext(10);
                    e.onNext(11);
                    e.onNext(12);
                    e.onComplete();
                }
        );
        source.subscribe(System.out::println);
    }

    public static void just() {
        Observable<Integer> just = Observable.just(1, 2, 3);
        just.subscribe(System.out::println);
    }

    public static void fromIterable() {
        List<String> list = List.of("Steven", "Andres", "Nicole");
        @NonNull
        Observable<String> fromIterable = Observable.fromIterable(list);
        fromIterable.subscribe(System.out::println);
    }

    public static void range() {
        Observable.range(3, 10)
                .subscribe(s -> System.out.println("RECEIVED; " + s));
    }

    public static void interval() throws InterruptedException {
        Observable.interval(1, TimeUnit.SECONDS);
        Thread.sleep(10000);
    }

    public static void defer() {
        List<String> list = new ArrayList<>();
        list.add("Steven");
        list.add("Andres");
        Observable<String> source = Observable.defer(
                () -> Observable.fromIterable(list));
        source.subscribe(System.out::println);
        list.add("Nicole");
        source.subscribe(System.out::println);
    }
}
