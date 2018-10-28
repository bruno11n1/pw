package pl.edu.pw.ii.concurrent;

// użyj zmiennej z pakietu .atomic

class Counter {
    private int c = 0;

    public void increment() {
        c++;
    }

    public int get() {
        return c;
    }
}

public class AtomSample {
    public static void main(String[] args) {
        Counter c = new Counter();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread() {
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        c.increment();
                    }
                    System.out.println(c.get());
                }
            };
            t.start();
        }

        try {  Thread.sleep(3000);   }  catch (InterruptedException e)  {  }
        System.out.println(c.get());
    }
}
