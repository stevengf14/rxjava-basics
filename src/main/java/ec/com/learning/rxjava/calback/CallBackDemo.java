package ec.com.learning.rxjava.calback;

/**
 *
 * @author Steven Guamán - February 2023
 */
public class CallBackDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main Thread is running");

        Runnable r = new Runnable() {
            @Override
            public void run() {
                new CallBackDemo().runningAsync(new CallBack() {
                    @Override
                    public void call() {
                        System.out.println("CallBack called!");
                    }

                });
            }

        };

        Thread t = new Thread(r);
        t.start();

        t.join();
        //Thread.sleep(2000);
        System.out.println("Main Thread Completed!");
    }

    public void runningAsync(CallBack callback) {
        System.out.println("I'm running in saperate thread");
        sleep(1000);
        callback.call();
    }

    private void sleep(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
