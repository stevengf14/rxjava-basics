package ec.com.learning.rxjava.concurrencyAndParallelization;

import io.reactivex.rxjava3.core.Observable;

/**
 *
 * @author Steven Guamán - April 2023
 */
public class ConcurrencyInRxJava {

    public static void main(String[] args) {

        Observable<String> source = Observable.create(
                e -> {
                    new Thread(()
                            -> {
                        e.onNext("Hello");
                        e.onNext("RxJava");
                    }).start();

                }
        );
        source
                .subscribe(e -> System.out.println("Observer 1: " + e + "| Thread is: " + Thread.currentThread().getName()));
        source
                .subscribe(e -> System.out.println("Observer 2: " + e + "| Thread is: " + Thread.currentThread().getName()));
    }

}
