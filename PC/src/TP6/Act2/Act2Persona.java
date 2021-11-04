package Act2;
public class Act2Persona implements Runnable{
    
    private boolean esJubilado;
    private Act2GestorSala gestor;

    public Act2Persona(Act2GestorSala gestor,boolean jub)
    {
        this.gestor = gestor;
        esJubilado = jub;
    }

    public void run()
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        //Intenta entrar a la sala.
        if(esJubilado)
        {
            gestor.entrarSalaJubilado();
        }
        else
        {
            gestor.entrarSala();;
        }

        //Recorre la sala.
        try {
            System.out.println(Thread.currentThread().getName() + " empieza a recorrer la sala.");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " termino de recorrer la sala.");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    
        //Deja la sala.
        gestor.salirSala();
    }
}
