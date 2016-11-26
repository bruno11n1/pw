package pl.edu.pw.ii.threads;

public class Thread2 extends Thread {

    public void run() {
        System.out.println("Thread " + getName() + " executed!");
    }

    public static void main(String args[]) throws InterruptedException {
        for (int i=0 ; i<10; i++) {
            Thread2 t = new Thread2();
            t.start();
        }
    }

}
