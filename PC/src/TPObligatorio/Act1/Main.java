
package Act1;

import Utiles.TecladoIn;

public class Main {

    public static void main(String[] args)
    {
        int x,y,z;

        //Declaracion de hreads encargados de sus respectivos procesos.
        Thread t1;
        Thread t2;
        Thread t3t4;

        //Runnable encargado de los procesos S3 y S4.Recurso compartido.
        S3S4 S3S4 = new S3S4();

        //Ingreso de informacion del usuario.
        System.out.println("Ingrese x:");
        x = TecladoIn.readLineInt();
        System.out.println("Ingrese y:");
        y = TecladoIn.readLineInt();
        System.out.println("Ingrese z:");
        z = TecladoIn.readLineInt();

        //Creacion de t1 y t2,
        t1 = new Thread(new S1(x, y, S3S4),"t1");
        t2 = new Thread(new S2(z, S3S4),"t2");
        t3t4 = new Thread(S3S4,"t3t4");

        //Se inician los hilos.
        t1.start();
        t3t4.start();
        t2.start();
    }
    
}
