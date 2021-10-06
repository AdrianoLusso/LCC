public class Animal implements Runnable {
    
    private char tipo;
    private static Comedor comedor = new Comedor(5);

    public Animal(char tipo)
    {
        this.tipo = tipo;
    }

    public void run()
    {
        //Ve si su tipo puede acceder al comedor
        comedor.verificarTipo(tipo);

        //Accede al comedor y se le asigna un plato
        comedor.acceder();
        //Come
        this.comer();
        //Come

        //Sale del comedor
        comedor.irse(tipo);
    }

    private void comer()
    {
        System.out.println(Thread.currentThread().getName() + " empieza a comer");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " termina de comer");
    }
}
