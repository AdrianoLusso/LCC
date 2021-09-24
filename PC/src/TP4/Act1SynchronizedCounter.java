public class Act1SynchronizedCounter {

    private int c = 0;

    public synchronized void increment() {c++;}

    public void decrement() {c--;}

    public synchronized int value() {return c;}
}

/*
Esta clase,si bien asegura consistencia de datos a la hora de incrementar o retornar c,no lo asegura
 a la hora de decrementarlo.

Deberia agregar un synch al decrement()
*/