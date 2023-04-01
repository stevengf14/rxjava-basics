/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ec.com.learning.rxjava.subjectsReplayingAndCaching;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Steven Guamán - March 2023
 */
public class Caching {

    public static void main(String[] args) throws InterruptedException {
        @NonNull
        Observable<@NonNull Long> src = Observable.interval(1, TimeUnit.SECONDS)
                .cache();

        src.subscribe(e -> System.out.println("Observable 1: " + e));

        Thread.sleep(5000);

        src.subscribe(e -> System.out.println("Observable 2: " + e));

        Thread.sleep(5000);
    }

}
