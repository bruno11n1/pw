package pl.edu.pw.ii.threads;

public class Thread3
{
    private int number = 0;

    public int balance()
    {
        number++;
        number--;
        return number;
    }

    public static void main(String[] args) {
        Thread3 sample = new Thread3();
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread() {
                public void run() {
                    System.out.println(getName() + " " + sample.balance());
                }
            };
            t.start();
        }
    };
}



