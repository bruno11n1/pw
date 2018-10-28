package pl.edu.pw.ii.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsSamples {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 16; i++) {
            list.add(i);
        }

        Collections.shuffle(list);

        // wydrukuj listę

        // wydrukuj kwadraty liczb

        // sprawdź, czy wszystkie liczby są mniejsze od 100

        // wybierz liczby nieparzyste i wydrukuj

        // wybierz liczby mniejsze od 8, posortuj i wydrukuj

        // wybierz liczby parzyste, posortuj i wydrukuj ich kwadraty

        List<String> sList =
                Arrays.asList("Joanna", "Ola", "Jan", "Ala", "Kazik");

        // posortuj, zamień na wielkie litery, wybierz imiona na J i wydrukuj

        // utwórz nową listę imion o długości 3
    }
}
