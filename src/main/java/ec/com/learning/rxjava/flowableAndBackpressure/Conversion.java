package ec.com.learning.rxjava.flowableAndBackpressure;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 *
 * @author Steven Guamán - April 2023
 */
public class Conversion {

    public static void main(String[] args) throws InterruptedException {

        /*Observable.range(1, 1000000)
                .toFlowable(BackpressureStrategy.BUFFER)
                .observeOn(Schedulers.io())
                .subscribe(e -> System.out.println(e + " " + Thread.currentThread().getName()));*/
        Flowable.range(1, 1000000)
                .toObservable()
                .observeOn(Schedulers.io())
                .subscribe(e -> System.out.println(e + " " + Thread.currentThread().getName()));

        Thread.sleep(5000);
    }

}
