package parcial2_Lusso_2908.Act1;

public class Repartidor implements Runnable {
    
    private Mostrador most;
    private Pedido ped;

    public Repartidor(Mostrador m)
    {
        most = m;
    }

    public void run()
    {
            while(most.quedaPedidoPorEntregar())
            {
            //Espera a que hagan 1 signal algun pizzero,de que hay algun pedido disponible
            ped = most.tomarPedido();

            //Viaja a entregar el pedido(thread sleep)
            System.out.println(Thread.currentThread().getName() +" esta llevando el pedido de " + ped.getCliente());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +" le dejo el pedido a " + ped.getCliente());


            //Vuelve a la pizzeria(thread sleep)
            System.out.println(Thread.currentThread().getName() +" esta volviendo a la pizeria");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +" llego a la pizeria");
            }

            //CODIGO DUPLICADO!
            //Espera a que hagan 1 signal algun pizzero,de que hay algun pedido disponible
            ped = most.tomarPedido();

            //Viaja a entregar el pedido(thread sleep)
            System.out.println(Thread.currentThread().getName() +" esta llevando el pedido de " + ped.getCliente());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +" le dejo el pedido a " + ped.getCliente());


            //Vuelve a la pizzeria(thread sleep)
            System.out.println(Thread.currentThread().getName() +" esta volviendo a la pizeria");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +" llego a la pizeria");
    }

    /*
    Cada 10 viajes que haga un repartidor se sienta a descansar
    comiendo una pizza hecha por algún cocinero...

    Al finalizar una iteracion de entrega,se compara cuanto pedidos lleva haciendo ese repartidor en particular.
    En caso de ser habe hecho 10,le pide al cocinero que le haga una piza especial,la cual luego de ser hecha
    sera ubicada en un "mostrador diferente" del cual podran sacar la piza que pidieron y comerla.Luego de hacer
    eso, vuelven a su comportamiento en bucle.

    */
}
