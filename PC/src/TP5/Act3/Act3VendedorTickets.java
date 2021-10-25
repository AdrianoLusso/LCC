package Act3;

public class Act3VendedorTickets implements Runnable {
    
    private Act3Tren tren;
    private int cantTicketsHoy;

    public Act3VendedorTickets(Act3Tren tren,int cantTicketsHoy)
    {
        this.tren = tren;
        this.cantTicketsHoy = cantTicketsHoy;
    }

    public void run()
    {
        //Ciclo.
        for(int i = 0;i < cantTicketsHoy;i++)
        {
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
        }
    }

}
