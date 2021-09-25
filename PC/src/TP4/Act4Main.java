public class Act4Main {

    public static void main (String[] args)
    {
        Thread uno = new Thread(new Act4Letra('A',1,1), "A");
        Thread dos = new Thread(new Act4Letra('B',2,2), "B");
        Thread tres = new Thread(new Act4Letra('C',3,3), "C");

        dos.start();
        tres.start();
        uno.start();
    }
}
