package Act2;

public class Empleado implements Runnable {
    
    private Comedor comedor;

    public Empleado (Comedor comedor)
    {
        this.comedor = comedor;
    }

    public void run (){

        comedor.entrar();

        comedor.pedirComida();

        comedor.esperarComida();

        System.out.println(Thread.currentThread().getName() + " empieza a comer.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        comedor.irse();
    }
}