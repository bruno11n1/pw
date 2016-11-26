package pl.edu.pw.ii.algorithms;

import java.util.ArrayList;
import java.util.List;

public class Algorithms {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<Person>();
        people.add(new Person("Jan", "Kowalski"));
        people.add(new Person("Marcin", "Kowalski"));
        people.add(new Person("Katarzyna", "Nowak"));
        people.add(new Person("Magdalena", "Szacka"));
        people.add(new Person("Janusz", "Szacki"));
        people.add(new Person("Tomasz", "Muchomor"));

        for(Person person : people) {
            System.out.println(person);
        }
    }
}
