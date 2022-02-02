package otrosMetodosTP.Act1;

import Utiles.TecladoIn;

public class OMSMain {
    
    public static void main(String[] args)
    {

        int cantPasajeros,cantEspacios;
        Thread[] arr;
        Thread control,vendedor;
        OMSTren tren;


        //Se pide info al usuario.
        System.out.println("Ingrese la cantidad de pasajeros:");
        cantPasajeros = TecladoIn.readLineInt();
        System.out.println("Ingrese la cantidad de espacios del tren.\nPrecondicion: los vagones siempre deben"
         +" poder llenarse.");
        cantEspacios = TecladoIn.readLineInt();

        //Se crea el tren, vendedor de tickets y control del tren.
        tren = new OMSTren(cantEspacios);
        control = new Thread(new OMSControlTren(tren,cantPasajeros),"controlador");
        vendedor = new Thread(new OMSVendedorTickets(tren,cantPasajeros),"vendedor");

        //Se crean los pasajeros.
        arr = new Thread[cantPasajeros];
        for(int i = 0;i<cantPasajeros;i++)
        {
            arr[i] = new Thread(new OMSPasajero(tren),"pasajero " + (i+1));
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
