package ec.com.learning.rxjava.combiningObservables;

import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Steven Guamán - March 2023
 */
public class MergeAndConcat {

    public static void main(String[] args) throws InterruptedException {

        /*Observable<String> src1 = Observable.just("Ella", "Alexa", "Lily");
        Observable<String> src2 = Observable.just("Priya", "Chloe");

        /*Observable.merge(src1, src2)
                .toList()
                .subscribe(System.out::println);

        Observable.concat(src1, src2)
                .toList()
                .subscribe(System.out::println);*/
        Observable<String> src1 = Observable.interval(1, TimeUnit.SECONDS).map(e -> "src1: " + e);
        Observable<String> src2 = Observable.interval(1, TimeUnit.SECONDS).map(e -> "src2: " + e);

        //Observable.merge(src1, src2)
        //.subscribe(e -> System.out.println("Received merge: " + e));  
        //Observable.concat(src1, src2)
        //.subscribe(e -> System.out.println("Received concat: " + e));
        src1.concatWith(src2)
                .subscribe(e -> System.out.println("Received concat: " + e));

        Thread.sleep(10000);

    }
}
