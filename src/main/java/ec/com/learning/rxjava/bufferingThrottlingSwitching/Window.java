package ec.com.learning.rxjava.bufferingThrottlingSwitching;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Steven Guamán - April 2023
 */
public class Window {

    public static void main(String[] args) throws InterruptedException {

        @NonNull
        Observable<Long> interval = Observable.interval(500, TimeUnit.MILLISECONDS);

        Observable.interval(1000, TimeUnit.MILLISECONDS)
                .window(interval)
                .subscribe(System.out::println);

        Thread.sleep(8000);
        
    }

}
