package otrosMetodosTP;

public class OMSPasajero implements Runnable{

    private OMSTren tren;

    public OMSPasajero(OMSTren tren)
    {
        this.tren = tren;
    }

    @Override
    public void run() {

        //Comprar ticket
        tren.comprarTicket();

        //Tratar de entrar al tren.Si no puede,espera.
        tren.entrarTren();

        //Realiza el viaje del tren.
        tren.viaje();

        //Se baja del tren.
        tren.bajarTren();
    }
    

    
}
