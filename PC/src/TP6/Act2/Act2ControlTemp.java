package Act2;

public class Act2ControlTemp implements Runnable {
    
    /*
    Asumiremos que cada vez entra un visitante nuevo a la sala, la temperatura de esta cambia
    aleatoriamente.
    */

    private Act2GestorSala gestor;
    private int cantVisitantesHoy;

    public Act2ControlTemp(Act2GestorSala gestor, int cant)
    {
        this.gestor = gestor;
        cantVisitantesHoy = cant;
    }

    public void run()
    {
        for(int i =0;i < cantVisitantesHoy;i++)
        {
            //Medir nueva temperatura.Solo cuando entra un nuevo visitante.
            gestor.medirTemperatura();
        }
    }
}
