class Act3Sincronizacion {
    public static void main(String[] args) 
    {
        int arr[]={1,2,3,4,5};// puede utilizar distintos valores para ver los cambios
        //con otros valores.

        Act3MiHilo mh1 = Act3MiHilo.creaEInicia("#1",arr);
        Act3MiHilo mh2 = Act3MiHilo.creaEInicia("#2",arr);
       try {
            mh1.hilo.join();
            mh2.hilo.join();
        }
        catch (InterruptedException exc){System.out.println("Hilo principal interrumpido.");} 
    }
}

/*
El resultado de la suma fue cambiando muchas veces,y no me dio el correcto.Logre que me diera
25,27 y 29.

En este caso,los join() no cambian en nada el funcionamiento del sistema.En caso de que luego de
los join,existiera mas codigo,ese codigo no seria ejecutado hasta que los 2 hilos previos hayan terminado.


*/