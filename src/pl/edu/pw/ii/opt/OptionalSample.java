package pl.edu.pw.ii.opt;

class Person {
    private String name;
    private String lastName;

    public String getName() {  return name;  }
    public void setName(String name) {  this.name = name;  }
    public String getLastName() {   return lastName;  }
    public void setLastName(String lastName) {   this.lastName = lastName;  }

    public String ToString() {
        // wydrukuj puste pola jeśli nie są ustawione
        // Optional, orElse, ofNullable
        return name + "\n" + lastName;
    }
}

public class OptionalSample {
    public static void main(String[] args) {
        Person p = new Person();

        System.out.println(p);

        // wydrukuj imię jeśli jest ustawione
        // Optional, ofNullable, ifPresent
    }
}
