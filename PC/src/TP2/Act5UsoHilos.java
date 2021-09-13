
public class Act5UsoHilos
{
    public static void main(String[] args)
    {
        System.out.println("Hilo principal iniciando");

        Act5MiHilo mh =new Act5MiHilo("#1");

        Thread nuevoHilo = new Thread(mh);

        nuevoHilo.start();

        for(int i = 0;i < 50;i++)
        {
            System.out.println(" .");
        }

        System.out.println("Hilo principal finalizado.");

    }

    /*
    a-Si quitamos los sleep:
    De la clase miHilo,entonces entre cada iteracion de contar,no se enviara ese hilo 
    a estado bloqueado.Esto hara que exista la posibilidad de que antes de que entre
    al iterativo de . en el main,sucedan 1 o mas iteraciones de contar en el hilo 
    nuevoHilo.
    Del main,aumentara las posibilidades de que el hilo principal no finalice a lo ultimo.

    b-Puede suceder.Dado que las iteraciones del main son mas que las del hilo,tiene menor probabilidad.Pero
    podria suceder,que incluso sin ningun sleep en la clase hilo,se ejecuten antes todas las iteraciones del main,y
    luego la finalizacion de este,antes que la del hilo.

    c y d:Hacerlos despues
    */
}

