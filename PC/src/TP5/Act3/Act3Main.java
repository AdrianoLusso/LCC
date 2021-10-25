package Act3;

import Utiles.TecladoIn;

public class Act3Main {
    
    public static void main(String[] args)
    {

        int cantPasajeros,cantEspacios;
        Thread[] arr;
        Thread control,vendedor;
        Act3Tren tren;


        //Se pide info al usuario.
        System.out.println("Ingrese la cantidad de pasajeros:");
        cantPasajeros = TecladoIn.readLineInt();
        System.out.println("Ingrese la cantidad de espacios del tren.\nPrecondicion: los vagones siempre deben"
         +" poder llenarse.");
        cantEspacios = TecladoIn.readLineInt();

        //Se crea el tren, vendedor de tickets y control del tren.
        tren = new Act3Tren(cantEspacios);
        control = new Thread(new Act3ControlTren(tren,cantPasajeros),"controlador");
        vendedor = new Thread(new Act3VendedorTickets(tren, cantPasajeros),"vendedor");

        //Se crean los pasajeros.
        arr = new Thread[cantPasajeros];
        for(int i = 0;i<cantPasajeros;i++)
        {
            arr[i] = new Thread(new Act3Pasajero(tren),"pasajero " + (i+1));
        }


        //Se inician los hilos.
        control.start();
        vendedor.start();
        for(int i = 0; i < cantPasajeros;i++)
        {
            arr[i].start();
        }
    }
}
