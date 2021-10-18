package Act2;

public class Main {
    public static void main(String[] args) {
        
        //Setee aqui la cantidad de empleados a atender.
        int cantEmpleados = 3;

        //Recurso compartido.
        Comedor comedor = new Comedor();

        Mozo m = new Mozo(comedor,cantEmpleados);
        Thread[] empleados = new Thread[cantEmpleados];

        //Creo el hilo mozo.
        Thread mozo = new Thread(m, "Mozo");

        //Creo los hilos empleados.
        for(int i = 0; i < cantEmpleados; i++)
        {
            empleados[i] = new Thread(new Empleado(comedor),i+1 +"");
        }
        
        //Inicio el hilo mozo.
        mozo.start();

        //Inicio los hilos empleados.
        for(int i = 0; i < cantEmpleados; i++)
        {
            empleados[i].start();;
        }
    }
}

/*

La mayor falencia en el uso de metodos/bloques synchs o locks explicitos en este ejercicio, es que no permiten
realizar un rendezvous entre 2 hilos. En este caso, era necesario para mantener una comunicacion eficiente entre
el mozo y el empleado que estuviera atendiendo en el momento.

Para suplir la falta de semaforos, utilize 2 booleans que me permiten emular su comportamiento, pero con una gran
deficiencia: el uso de espera activa. Cuando el mozo debe esperar a que le pidan de comer, o cuando el empleado
esta esperando su comida, tuve que aplicar espera activa.

El uso de locks implicitos si me permite lograr la exclusion mutua, entre partes de codigos de diferentes metodos.
Por eso, decidi usar un lock mutex que suplanta exitosamente el uso de un semaforo mutex.

*/
