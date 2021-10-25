package Act3;

public class Act3Pasajero implements Runnable{

    private Act3Tren tren;

    public Act3Pasajero(Act3Tren tren)
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
