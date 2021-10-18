package Act1;
public class Act1Animal implements Runnable {
    
    //true: perro, false: gato
    private static Act1Comedor comedor = new Act1Comedor(5);
    private boolean tipo;

    public Act1Animal(boolean tipo)
    {
        this.tipo = tipo;
    }

    public void run()
    {
        //Intentar entrar al comedor.Se filtra segun su tipo.
        comedor.entrar(tipo);

        //Esta dentro del comedor,y trata de tomar un plato.Si no hay libres,espera a que se libere uno.
        comedor.buscarPlato();

        //Come
        System.out.println(Thread.currentThread().getName()+" empezo a comer.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" termino a comer.");

        //Al terminar de comer,deja el plato y abandona el comedor.
        comedor.irse(tipo);

    }
}
