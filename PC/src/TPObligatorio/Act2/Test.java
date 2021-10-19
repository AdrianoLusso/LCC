package Act2;

public class Test {
    public static void main(String[] args) {
        Fabrica f= new Fabrica ();
        Thread emb= new Thread (new Embotellador(f));
        Thread emp= new Thread (new Empaquetador(f));

        emb.start();
        emp.start();
    }
}
