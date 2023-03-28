package ec.com.learning.rxjava.combiningObservables;

import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Steven Guamán - March 2023
 */
public class ZipAndCombineLatest {

    public static void main(String[] args) throws InterruptedException {

        Observable<Long> src1 = Observable.interval(200, TimeUnit.MILLISECONDS).take(10);

        Observable<Long> src2 = Observable.interval(1, TimeUnit.SECONDS).take(10);

//        Observable.zip(src1, src2, (e1, e2) -> "Source 1: " + e1 + " Source 2:" + e2)
//                .subscribe(System.out::println);
        Observable.combineLatest(src1, src2, (e1, e2) -> "Source 1: " + e1 + " Source 2:" + e2)
                .subscribe(System.out::println);

        Thread.sleep(20000);
    }

}
