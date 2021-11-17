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
}
