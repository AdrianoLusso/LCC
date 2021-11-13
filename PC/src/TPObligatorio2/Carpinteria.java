import Utiles.TecladoIn;

public class Carpinteria {
    
    public static void main(String[] args)
    {
        int M,N1,N2,N3,N;
        Buffer buffer;
        Thread[] carp;

        //Se pide informacion al usuario.
        System.out.println("Ingrese la cantidad de muebles a fabricar:");
        M = TecladoIn.readLineInt();
        System.out.println("Ingrese la cantidad de carpinteros ensambladores:");
        N = TecladoIn.readLineInt();
        System.out.println("Ingrese la cantidad de carpinteros de parte 1:");
        N1 = TecladoIn.readLineInt();
        System.out.println("Ingrese la cantidad de carpinteros de parte 2:");
        N2 = TecladoIn.readLineInt();
        System.out.println("Ingrese la cantidad de carpinteros de parte 3:");
        N3 = TecladoIn.readLineInt();

        //Se crea el recurso compartido y col de hilos.
        buffer = new Buffer(M);
        carp = new Thread[N+N1+N2+N3];

        //Se crean ensambladores.
        for(int i = 0;i < N;i++)
        {
            System.out.println(i);
            carp[i] = new Thread(new Carpintero(0, buffer), "ensamblador " +(i+1));
        }

        //Se crean carpinteros 1.
        for(int i = N;i < N+N1;i++)
        {
            System.out.println(i);

            carp[i] = new Thread(new Carpintero(1, buffer), "carpintero UNO. " +(i+1));
        }

        //Se crean carpinteros 2.
        for(int i = N+N1;i < N+N1+N2;i++)
        {
            System.out.println(i);
            carp[i] = new Thread(new Carpintero(2, buffer), "carpintero DOS. " +(i+1));
        }

        //Se crean carpinteros 1.
        for(int i = N+N1+N2;i < N+N1+N2+N3;i++)
        {
            System.out.println(i);
            carp[i] = new Thread(new Carpintero(3, buffer), "carpintero TRES. " +(i+1));
        }

        //Se corren los hilos.
        for(int i = 0; i < M+N1+N2+N3;i++)
        {
            System.out.println("wiii");
            carp[i].run();
        }
    }
}
