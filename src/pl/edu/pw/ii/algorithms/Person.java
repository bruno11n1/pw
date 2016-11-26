package pl.edu.pw.ii.algorithms;

public class Person {
    private String name;
    private String surname;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String toString() {
        return surname + " " + name;
    }

    public int compareTo(Person o) {
        int surnameCompare = surname.compareTo(o.surname);

        if(surnameCompare == 0) {
            return name.compareTo(o.name);
        }
        else {
            return surnameCompare;
        }
    }
}
