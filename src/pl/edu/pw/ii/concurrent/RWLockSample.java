package pl.edu.pw.ii.concurrent;

import java.util.concurrent.locks.ReentrantReadWriteLock;

// uzyj ReentrantReadWriteLock do rozwiazania problemu czytelnikow i pisarzy

class Data {
    final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void set() {
        System.out.println("Set start...");
        try {  Thread.sleep(1000);   }  catch (InterruptedException e)  {  }
        System.out.println("Set finish...");
    }

    public int get() {
        System.out.println("Get start...");
        try {  Thread.sleep(1000);   }  catch (InterruptedException e)  {  }
        System.out.println("Get finish...");
        return 0;
    }
}

public class RWLockSample {
    public static void main(String[] args) {
        Data c = new Data();
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread() {
                public void run() {
                        c.set();
                }
            };
            t.start();
        }

        for (int i = 0; i < 5; i++) {
            Thread t = new Thread() {
                public void run() {
                        c.get();
                }
            };
            t.start();
        }
    }
}
