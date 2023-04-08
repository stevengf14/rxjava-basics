package ec.com.learning.rxjava.subjectsReplayingAndCaching;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.AsyncSubject;
import io.reactivex.rxjava3.subjects.BehaviorSubject;
import io.reactivex.rxjava3.subjects.Subject;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.ReplaySubject;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Steven Guamán - April 2023
 */
public class SubjectTypes {

    public static void main(String[] args) throws InterruptedException {
        // Publish Subject
        executePublishSubject();

        // Replay Subject
        executeReplaySubject();

        // Behavior Subject
        executeBehaviorSubject();

        // Async Subject
        executeAsyncSubject();

        // Unicast Subject
        executeUnicastSubject();

    }

    public static void executePublishSubject() {
        System.out.println("****** Publish Subject ******");

        Subject<String> subject = PublishSubject.create();

        subject.subscribe(e -> System.out.println("Subscriber 1: " + e));

        subject.onNext("a");
        subject.onNext("b");
        subject.onNext("c");

        subject.subscribe(e -> System.out.println("Subscriber 2: " + e));

        subject.onNext("d");
        subject.onNext("e");
        subject.onComplete();
    }

    public static void executeReplaySubject() {
        System.out.println("****** Replay Subject ******");

        Subject<String> subject = ReplaySubject.create();

        subject.subscribe(e -> System.out.println("Subscriber 1: " + e));

        subject.onNext("a");
        subject.onNext("b");
        subject.onNext("c");

        subject.subscribe(e -> System.out.println("Subscriber 2: " + e));

        subject.onNext("d");
        subject.onNext("e");
        subject.onComplete();
    }

    public static void executeBehaviorSubject() {
        System.out.println("****** Behavior Subject ******");

        Subject<String> subject = BehaviorSubject.create();

        subject.subscribe(e -> System.out.println("Subscriber 1: " + e));

        subject.onNext("a");
        subject.onNext("b");
        subject.onNext("c");

        subject.subscribe(e -> System.out.println("Subscriber 2: " + e));

        subject.onNext("d");
        subject.onNext("e");
        subject.onComplete();
    }

    public static void executeAsyncSubject() {
        System.out.println("****** Async Subject ******");

        Subject<String> subject = AsyncSubject.create();

        subject.subscribe(e -> System.out.println("Subscriber 1: " + e));

        subject.onNext("a");
        subject.onNext("b");
        subject.onNext("c");

        subject.subscribe(e -> System.out.println("Subscriber 2: " + e));

        subject.onNext("d");
        subject.onNext("e");
        subject.onComplete();
    }

    public static void executeUnicastSubject() throws InterruptedException {
        System.out.println("****** Unicast Subject ******");

        Subject<Long> subject = UnicastSubject.create();

        Observable.interval(500, TimeUnit.MILLISECONDS)
                .subscribe(subject);

        Thread.sleep(2000);

        subject.subscribe(e -> System.out.println("Subscriber 1: " + e));

//        subject.onNext("a");
//        subject.onNext("b");
//        subject.onNext("c");
//
//        subject.subscribe(e -> System.out.println("Subscriber 2: " + e));
//
//        subject.onNext("d");
//        subject.onNext("e");
//        subject.onComplete();
    }

}
