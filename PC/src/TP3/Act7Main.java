import java.util.Random;

import Utiles.TecladoIn;

public class Act7Main {
    
    public static void main(String[] args)
    {
        int fin,k,i,longTramo;
        Thread[] sumadores;
        int[] arr = new int[50000];

        for(i = 0;i < 50000;i++)
        {
            arr[i] = 1;
        }

        System.out.println("Ingrese la cantidad de hilos:");
        k = TecladoIn.readLineInt();
        longTramo = 50000 / k;

        sumadores = new Thread[k];

        for(i = 0;i<k;i++)
        {
            if(i == k-1)
            {
                fin = arr.length - 1;
            }
            else
            {
                fin =  (i+1) * longTramo - 1;
            }
            sumadores[i] = new Thread(new Act7Sumador(i * longTramo,fin,arr),"" + i);
            sumadores[i].start();
        }

        for(i = 0;i < k;i++)
        {
            try {
                sumadores[i].join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        Act7Sumador.mostrarResFinal();
    }
}
