package pl.edu.pw.ii.concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class FindMinTask extends RecursiveTask<Integer> {

    private Integer[] arr;
    private int start, end;

    public FindMinTask(Integer[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start < 128) {
            int min = Integer.MAX_VALUE;
            for (int i = start; i < end; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                }
            }
            return min;
        } else {
            int middle = start + (end-start) / 2;

            FindMinTask left = new FindMinTask(arr, start, middle);
            FindMinTask right = new FindMinTask(arr, middle, end);

            invokeAll(left, right);

            return Integer.min(left.join(), right.join());
        }
    }
}

public class ForkJoinSample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 512; i++) {
            list.add(i);
        }

        Collections.shuffle(list);

        Integer[] data = list.toArray(new Integer[list.size()]);

        // ile wątków będzie uruchamianych?
        ForkJoinPool pool = new ForkJoinPool();

        FindMinTask task = new FindMinTask(data, 0, data.length);
        Integer result = pool.invoke(task);

        System.out.println("min value = " + result);
    }
}
