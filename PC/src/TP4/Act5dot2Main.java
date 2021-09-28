public class Act5dot2Main {
    
    public static void main(String[] args)
    {
        Thread uno = new Thread(new Act5Usuario('A'),"Uno");
        Thread dos = new Thread(new Act5Usuario('A'),"Dos");
        Thread tres = new Thread(new Act5Usuario('A'),"Tres");
        Thread cuatro = new Thread(new Act5Usuario('A'),"Cuatro");
        Thread cinco = new Thread(new Act5Usuario('A'),"Cinco");
        Thread seis = new Thread(new Act5Usuario('A'),"Seis");
        Thread siete = new Thread(new Act5Usuario('-'),"Siete");
        Thread ocho = new Thread(new Act5Usuario('-'),"Ocho");

        cinco.start();
        dos.start();
        tres.start();
        cuatro.start();
        uno.start();
        ocho.start();
        seis.start();
        siete.start();
    }
}
