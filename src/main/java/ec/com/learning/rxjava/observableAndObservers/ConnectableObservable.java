package ec.com.learning.rxjava.observableAndObservers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Steven Guamán - March 2023
 */
public class ConnectableObservable {

    public static void main(String[] args) throws InterruptedException {
        io.reactivex.rxjava3.observables.@NonNull ConnectableObservable<@NonNull Long> source = Observable.interval(1, TimeUnit.SECONDS).publish();

        source.connect();

        source.subscribe(System.out::println);

        Thread.sleep(10000);
        source.subscribe(System.out::println);

        Thread.sleep(10000);
    }
}
