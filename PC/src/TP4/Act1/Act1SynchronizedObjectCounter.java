package Act1;
public class Act1SynchronizedObjectCounter {
    
    private int c = 0;

    public void increment(){
    synchronized ((Integer) c) {c++;} // Este elemento debe ser casteado a
    //Integer
    }

    public void decrement() {
    synchronized (this) {c--;}
    }

    public int value() {return c;}

    //Este metodo asegura consistencia de datos a la hora de decrementar c,pero a la hora de
    //retornarlo y incrementarlo.
    //Para solucionarlo,deberia syncronizar value(), y cambiar el objeto que se sincroniza en incremente
    // de C a THIS
}
