package parcial2.Act1;

public class Pizzero implements Runnable {
    
    //true: napolitana, false:vegana.
    private boolean tipo;
    private Mostrador most;

    public Pizzero(Mostrador m)
    {
        most = m;
    }

    public void run()
    {
        boolean termino;

        termino = most.esperarPedido(tipo);
        
        while(!termino)
        {
        //Le notifican de un pedido de SU TIPO.Para cada tipo hay una Condition
        //ESTO TENIA QUE BORRARLO!
        most.esperarPedido(tipo);

        //Empieza a armar la piza.PERO DEBE CORROBORAR QUE HAYA ESPACIO EN EL MOSTRADOR.
        //SINO,ESPERA A QUE HAYA ESPACIO Y LUEGO EMPIEZA A ARMARLA
        most.empezarPedido();

        //Cocina la piza(thread sleep)
        if(tipo)
        {
            System.out.println(Thread.currentThread().getName()+ " empieza a cocinar la piza napolitana.");
        }
        else
        {
            System.out.println(Thread.currentThread().getName()+ " empieza a cocinar las 2 pizas veganas.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        //Deja la pizza en el mostrador
        most.dejarPedido(tipo);

        termino = most.esperarPedido(tipo);
        }

    }
}
