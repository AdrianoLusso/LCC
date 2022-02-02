package parcial2.Act1;

import java.util.Random;

public class GeneradorPedidos implements Runnable {
    
    private Mostrador most;
    private int cantPedidosHoy;

    public GeneradorPedidos(Mostrador m,int cant)
    {
        most = m;
        cantPedidosHoy = cant;
    }

    public void run()
    {
        Random r = new Random();

        for(int i = 0;i<cantPedidosHoy;i++)
        {
            //Genera un pedido ALEATORIO.Es decir,hara un signal de la respectiva condition
            most.enviarOrden(i,new Pedido("Cliente "+0,r.nextBoolean()));

            //Sleep para que tarde en generar otro pedido
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
