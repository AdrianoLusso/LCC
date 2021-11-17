package Act5;

import Utiles.TecladoIn;

public class Parque {

    public static void main(String[] args)
    {
        int n;
        Thread[] visitante;

        System.out.println("Ingrse cantidad de visitantes:");
        n = TecladoIn.readLineInt();

        visitante = new Thread[n];

        for(int i = 0; i<n;i++)
        {
            visitante[i] = new Thread(new Visitantee(), "visitnte " +(i+1));
        }

        for(int i = 0; i<n;i++)
        {
            visitante[i].start();;
        }
    }
}

