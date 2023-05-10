package ec.com.learning.rxjava.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

/**
 *
 * @author Steven Guamán - May 2023
 */
public class SettingParallelism {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        System.out.println(Runtime.getRuntime().availableProcessors());

        System.getProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "2");

        System.out.println(ForkJoinPool.getCommonPoolParallelism());

        ForkJoinPool pool = new ForkJoinPool(2);

        List<Employee> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new Employee("Jhon", 20000));
            list.add(new Employee("Rohn", 3000));
            list.add(new Employee("Tom", 15000));
            list.add(new Employee("Bheem", 8000));
            list.add(new Employee("Shiva", 200));
            list.add(new Employee("Krishna", 50000));
        }

        long count = pool.submit(()
                -> list.parallelStream()
                        .filter(e -> e.getSalary() > 100)
                        .count()).get();

        System.out.println(count);
        
        // Computational Intensive
        // Number of Threads <= Number of Cores
        
        // IO intensive
        // Number of Threads > Number of Cores
    }

}
