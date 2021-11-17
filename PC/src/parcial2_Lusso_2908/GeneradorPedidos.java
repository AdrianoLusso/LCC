package parcial2_Lusso_2908;

public class GeneradorPedidos implements Runnable {
    
    private int cantPedidosHoy;

    public GeneradorPedidos(int cant)
    {
        cantPedidosHoy = cant;
    }

    public void run()
    {
        for(int i = 0;i<cantPedidosHoy;i++)
        {
            //Genera un pedido ALEATORIO.Es decir,hara un signal de la respectiva condition
            

            //Sleep para que tarde en generar otro pedido
        }
    }
}
