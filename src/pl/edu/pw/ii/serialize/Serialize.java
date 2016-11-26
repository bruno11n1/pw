package pl.edu.pw.ii.serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;

public class Serialize {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filename = "dane.dat";

        Set<String> someStrings = new HashSet<String>();
        someStrings.add("moje");
        someStrings.add("dane");

        // serializacja
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(filename));
        oos.writeObject(someStrings);

        // deserializacja
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(filename));
        Set<String> aNewSet = (HashSet<String>) ois.readObject();

        System.out.println(aNewSet);
    }
}
