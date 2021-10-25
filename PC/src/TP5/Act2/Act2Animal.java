package Act2;
public class Act2Animal implements Runnable {
    
    //true: perro, false: gato
    private static Act2Comedor comedor = new Act2Comedor(3);
    private boolean tipo;
    private int itr;

    public Act2Animal(boolean tipo)
    {
        this.tipo = tipo;
        if(tipo)
        {
            itr = 2;
        }
        else
        {
            itr = 1;
        }
    }

    public void run()
    {
        //Intentar entrar al comedor.Se filtra segun su tipo.
        comedor.entrar(tipo);

        for(int i = 0 ;i < itr;i++)
        {
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

            //libera el plato.
            comedor.liberarPlato();
        }
       
        //Abandona el comedor.
        comedor.irse(tipo);
    }

    private void bifurcacionPerro()
    {
        
    }
}