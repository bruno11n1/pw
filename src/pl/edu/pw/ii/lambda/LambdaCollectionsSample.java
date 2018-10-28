package pl.edu.pw.ii.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaCollectionsSample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 16; i++) {
            list.add(i);
        }

        Collections.shuffle(list);

        // wydrukuj kolekcję

        // posortuj rosnąco

        // posortuj malejąco

        // usuń liczby parzyste
    }
}
