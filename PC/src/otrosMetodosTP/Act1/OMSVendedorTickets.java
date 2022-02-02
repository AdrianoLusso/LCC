package otrosMetodosTP.Act1;

public class OMSVendedorTickets implements Runnable {
    
    private OMSTren tren;
    private int cantTicketsHoy;

    public OMSVendedorTickets(OMSTren tren,int cant)
    {
        this.tren = tren;
        cantTicketsHoy = cant;
    }

    public void run()
    {

        do{
            //Esperar a que una persona quiera comprar un ticket.
            tren.iniciarVenta();

            //Realizar proceso de impresion de ticket.
            System.out.println(Thread.currentThread().getName() + " esta imprimiendo el ticket.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            //Entregar el ticket.
            tren.entregarTicket();

            cantTicketsHoy--;
        }while(cantTicketsHoy>0);

    }

}
