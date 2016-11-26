package pl.edu.pw.ii.threads;

public class ProdCons {
    public static void main(String[] args) throws InterruptedException {
        Storage storage = new Storage();
        Thread c = new Thread() {
            public void run() {
                for (int i = 0; i<10; i++) {
                    System.out.println("Konsument pobral " + storage.get());
                }
            }
        };
        Thread p = new Thread() {
            public void run() {
                for (int i = 0; i<10; i++) {
                    storage.put(i);
                    System.out.println("Producent wyprodukowal " + i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                    }
                }
            }
        };
    }
}

class Storage {
    private int value;
    private boolean hasValue = false;

    public int get() {
        while (hasValue == false) {
        }
        hasValue = false;
        return value;
    }

    public void put(int value) {
        while (hasValue == true) {
        }
        hasValue = true;
        this.value = value;
    }
}
