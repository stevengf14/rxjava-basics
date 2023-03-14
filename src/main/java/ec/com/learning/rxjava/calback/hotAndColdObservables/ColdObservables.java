package ec.com.learning.rxjava.calback.hotAndColdObservables;

import io.reactivex.rxjava3.core.Observable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Steven Guamán - March 2023
 */
public class ColdObservables {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(16);
        list.add(17);
        list.add(18);

        Observable<Integer> source = Observable.fromIterable(list);
        source.subscribe(System.out::println);
        list = getData(list);
        source.subscribe(System.out::println);
    }

    private static List<Integer> getData(List<Integer> list) {
        list.add(19);
        return list;
    }
}
