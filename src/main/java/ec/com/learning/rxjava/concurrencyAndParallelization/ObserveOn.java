package ec.com.learning.rxjava.concurrencyAndParallelization;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 *
 * @author Steven Guamán - April 2023
 */
public class ObserveOn {

    public static void main(String[] args) throws InterruptedException {

        Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
                .subscribeOn(Schedulers.computation())
                .map(e -> e.toUpperCase())
                .doOnNext(e-> System.out.println(Thread.currentThread().getName()))
                .filter(e -> e.startsWith("P"))
                .observeOn(Schedulers.io())
                .subscribe(e -> print(e));

        Thread.sleep(6000);

    }

    public static void print(String element) throws InterruptedException {
        System.out.println(element + ": Printed By : " + Thread.currentThread().getName());
    }

}
