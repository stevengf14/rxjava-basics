package ec.com.learning.rxjava.creating.observer;

import io.reactivex.rxjava3.core.Observable;

/**
 *
 * @author Steven Guamán - March 2023
 */
public class CreatingObserver {

    public static void main(String[] args) {
        Observable<String> source = Observable.just("Orange", "Black", "Red");
        source.subscribe(i -> System.out.println(i), Throwable::printStackTrace, () -> System.out.println("Copmpleted!"));
        System.out.println();
        source.subscribe(i -> System.out.println(i), Throwable::printStackTrace);
        System.out.println();
        source.subscribe(i -> System.out.println(i));
    }

}
