package pl.edu.pw.ii.daemon;

public class DaemonSample extends Thread {

    public static void main(String[] args) {
        System.out.println("Start");

        DaemonSample t = new DaemonSample();
        t.setDaemon(false);
        t.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException x) {
        }

        System.out.println("Bye");
    }

    public void run() {
        System.out.println("Thread entry " + Thread.currentThread());
        try {
            while (true) {
                Thread.sleep(1000);
                System.out.println("Working " + Thread.currentThread());
            }
        } catch (InterruptedException x) {
        }
        System.out.println("Thread exit " + Thread.currentThread());
    }
}
