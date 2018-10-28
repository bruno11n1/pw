package pl.edu.pw.ii.lambda;

interface Sample {
    public double sample();
}

// uprość poniższe wyrażenia

// dodaj nowe wyrażenie typu pi i sprawdź pokrycie kodu

// dodaj interfejs z metodą zwracającą int i przyjmującą 2 x int
// zaimplementuj dodawanie

// korzystając ze standardowych interfejsów zaimplementuj liczenie kwadratu

public class LambdaSamples {
    public static void test(Sample s)
    {
        System.out.println(s.sample());
    }

    public static void main(String[] args) {
        Sample pi = () -> { return 3.14; };

        test(pi);
        test(() -> { return 9.0; });
    }
}
