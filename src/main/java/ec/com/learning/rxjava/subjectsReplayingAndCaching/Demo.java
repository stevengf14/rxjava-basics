package ec.com.learning.rxjava.subjectsReplayingAndCaching;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

/**
 *
 * @author Steven Guamán - April 2023
 */
public class Demo {

    public static void main(String[] args) {

        @NonNull
        PublishSubject<String> subject = PublishSubject.create();
        @NonNull
        Subject<String> serialized = subject.toSerialized();

        serialized.subscribe(System.out::println);
        serialized.subscribe(e -> System.out.println("Observer 2: " + e));

        serialized.onNext("Hello");
        serialized.onNext("BasicsStrong");
        serialized.onComplete();
        serialized.onNext("BasicsStrong");
    }

}
