package pl.edu.pw.ii.threads;

public class Thread1 implements Runnable {

    public void run() {
        System.out.println("Thread executed!");
    }

    public static void main(String args[]) {
        Thread t = new Thread(new Thread1());
        t.start();
    }
}