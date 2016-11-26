package pl.edu.pw.ii.collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

public class MapTest {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.nanoTime();

        Map<Integer, String> testMap = new ConcurrentHashMap<Integer, String>();

        for (int i = 0; i < 5; i++) {
            Thread t = new Thread() {
                public void run() {
                    for (int i = 0; i < 500000; i++) {
                        int random = ThreadLocalRandom.current().nextInt(0, 500000);
                        String test = testMap.get(random);
                        testMap.put(random, String.valueOf(random));
                    }
                }
            };
            t.start();
        }

        long stopTime = System.nanoTime();

        System.out.println("Czas wykonania: " + ((stopTime - startTime) / 1000000L) + " ms");
    }
}
