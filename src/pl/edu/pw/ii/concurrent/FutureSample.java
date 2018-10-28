package pl.edu.pw.ii.concurrent;

import java.util.concurrent.*;

class FutureSampleTask implements Callable {
    @Override
    public String call() {
        return "solution";
    }
}

public class FutureSample {

    public static void main(String args[]) throws InterruptedException, ExecutionException {

        ExecutorService pool = Executors.newFixedThreadPool(3);

        FutureSampleTask task = new FutureSampleTask();
        Future future = pool.submit(task);

        while (!future.isDone()) {
            System.out.println("FutureSampleTask is not completed...");
            Thread.sleep(1);
        }

        System.out.println("FutureSampleTask is completed");
        String solution = (String) future.get();
        System.out.println(solution);

        pool.shutdown();
    }
}
