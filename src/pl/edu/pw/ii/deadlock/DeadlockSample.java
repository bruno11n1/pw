package pl.edu.pw.ii.deadlock;

public class DeadlockSample {
    public static void main(String[] args) {

        final Object lock1 = new Object();
        final Object lock2 = new Object();

        Thread t1 = new Thread() {
            public void run() {
                synchronized(lock1){
                    System.out.println("Thread 1 lock1");
                    Thread.yield();
                    synchronized(lock2){
                        System.out.println("Thread 1 lock2");
                    }
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                synchronized(lock2){
                    System.out.println("Thread 2 lock1");
                    Thread.yield();
                    synchronized(lock1){
                        System.out.println("Thread 2 lock2");
                    }
                }
            }
        };

        t1.start();
        t2.start();
    }
}
