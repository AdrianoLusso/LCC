package otrosMetodosTP.Act2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

import Utiles.TecladoIn;
import otrosMetodosTP.Act2.OMSCajero;
import otrosMetodosTP.Act2.OMSCliente;

public class OMSMercado {
    
    public static void main(String[] args) throws IOException
    {
        OMSCaja caja = new OMSCaja();

        Thread cliente1 = new Thread(new OMSCliente(caja,new int[]{2,3,4,2,4,3}),"cliente 1");
        Thread cliente2 = new Thread(new OMSCliente(caja,new int[]{5,6}),"cliente 2");
        Thread cliente3 = new Thread(new OMSCliente(caja,new int[]{1,1,7,3}),"cliente 3");
        Thread cliente4 = new Thread(new OMSCliente(caja,new int[]{5,2,3,2}),"cliente 4");

        Thread cajero = new Thread(new OMSCajero(caja,4),"cajero");

        cajero.start();
        cliente1.start();
        cliente2.start();
        cliente3.start();
        cliente4.start();
    }
}
