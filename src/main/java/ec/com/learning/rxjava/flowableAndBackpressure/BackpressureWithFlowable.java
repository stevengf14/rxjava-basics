package ec.com.learning.rxjava.flowableAndBackpressure;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 *
 * @author Steven Guamán - April 2023
 */
public class BackpressureWithFlowable {

    public static void main(String[] args) {

        Flowable.range(1, 1000000)
                .map(e -> {
                    System.out.println("Produced item is: " + e + ": " + Thread.currentThread().getName());
                    return e;
                }).observeOn(Schedulers.io())
                .subscribe(new Subscriber<Integer>() {

                    Subscription s;
                    AtomicInteger count = new AtomicInteger(0);

                    @Override
                    public void onSubscribe(Subscription s) {
                        this.s = s;
                        System.out.println("Asking for 20 items");
                        s.request(20);
                    }

                    @Override
                    public void onNext(Integer t) {
                        System.out.println("The subscriber consumed: " + t);
                        if (count.getAndIncrement() % 20 == 0) {
                            System.out.println("Asking for next 20 items");
                            s.request(20);
                        }
                        sleep(100);
                    }

                    @Override
                    public void onError(Throwable t) {
                        t.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Completed!");
                    }
                });

        sleep(10000000);
    }

    private static void sleep(long milliseconds) {

        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException ex) {
            Logger.getLogger(BackpressureWithFlowable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
