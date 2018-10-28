package pl.edu.pw.ii.concurrent;

import java.util.concurrent.*;

class Task implements Runnable {

    private String name;

    public Task(String name) {
        this.name = name;
    }

    public void run() {
        for (int i=0; i<3; i++) {
            System.out.println(name + " " + i);
            Thread.yield();
        }
    }
}

public class ExecutorSample {

    public static void main(String[] args) {

        // jakiego wykonawcy użyć by wykorzystać możliwości platformy?
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i=0; i<16; i++) {
            executor.execute(new Task("Task " + i));
        }

        /*
        executor.shutdownNow();
        */
        /*
        executor.shutdown();
        executor.execute(new Task("Last task"));
        */
    }
}