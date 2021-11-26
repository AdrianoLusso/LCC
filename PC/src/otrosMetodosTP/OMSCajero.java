package otrosMetodosTP;

public class OMSCajero implements Runnable {
    
    private int cantClientesHoy;
    private OMSCaja caja = new OMSCaja();

    public OMSCajero(int cant)
    {
        cantClientesHoy = cant;
    }

    public void run()
    {
        for(int i=0; i < cantClientesHoy;i++)
        {
            //Esperar a que llegue el cliente.
            caja.tomarCompra();

            //Escanea su compra,y le retorna el ticket al cliente.
            caja.escanear();

            //Recibirdinero,y entregar compra
            caja.cobrar();
        }
    }
}
