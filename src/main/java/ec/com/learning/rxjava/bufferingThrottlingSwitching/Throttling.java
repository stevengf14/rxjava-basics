package ec.com.learning.rxjava.bufferingThrottlingSwitching;

import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Steven Guamán - April 2023
 */
public class Throttling {

    public static void main(String[] args) {

        Observable<String> obs = Observable.create(emitter -> {
            emitter.onNext("A");

            Thread.sleep(200);
            emitter.onNext("B");

            Thread.sleep(100);
            emitter.onNext("C");

            Thread.sleep(400);
            emitter.onNext("D");

            Thread.sleep(300);
            emitter.onNext("E");

            Thread.sleep(800);
            emitter.onNext("F");

            Thread.sleep(900);
            emitter.onNext("X");

            Thread.sleep(800);
            emitter.onNext("Y");

            Thread.sleep(1000);
            emitter.onNext("Z");

            emitter.onComplete();
        });

        obs
                //.throttleFirst(1000, TimeUnit.MILLISECONDS)
                //.throttleLast(1000, TimeUnit.MILLISECONDS)
                //.sample(1000, TimeUnit.MILLISECONDS)
                //.throttleWithTimeout(1000, TimeUnit.MILLISECONDS)
                .debounce(700, TimeUnit.MILLISECONDS)
                .subscribe(
                        item -> System.out.println("OnNext: " + item),
                        Throwable::printStackTrace,
                        () -> System.out.println("OnComplete")
                );
    }

}
