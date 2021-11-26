package otrosMetodosTP;

public class OMSCliente implements Runnable {
    
    private int[] compra;
    private OMSCaja caja = new OMSCaja();

    public OMSCliente(OMSCaja caja, int[] compra)
    {
        this.caja = caja;
        this.compra = compra;
    }

    public void run()
    {
        int precio;

        //Llega al cajero y le entrega toda su compra.
        caja.dejarCompra(compra);

        //Espera a que el cajero escanee la compra, y le entregue el ticket.
        precio = caja.tomarTicket();

        //Le paga al cajero la compra.
        compra = caja.pagar(precio);
    }
}
