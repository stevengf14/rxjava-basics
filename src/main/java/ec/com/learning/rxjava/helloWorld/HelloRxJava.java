package ec.com.learning.rxjava.helloWorld;

import io.reactivex.rxjava3.core.Observable;

/**
 *
 * @author Steven Guamán - February 2023
 */
public class HelloRxJava {

    public static void main(String[] args) {

        Observable<String> source = Observable.create(
                e -> {
                    e.onNext("Hello");
                    e.onNext("RxJava");
                }
        );
        source.subscribe(e -> System.out.println("Observer 1: " + e));
        source.subscribe(e -> System.out.println("Observer 2: " + e));
    }
}
