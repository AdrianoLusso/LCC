package parcial2_Lusso_2908;

public class Pizzero implements Runnable {
    
    //true: napolitana, false:vegana.
    private boolean tipo;
    private Mostrador most = new Mostrador();

    public static void main(String[] args)
    {

    }

    public Pizzero()
    {

    }

    public void run()
    {
        //bucle de no se cuanto
        {
        //Le notifican de un pedido de SU TIPO.Para cada tipo hay una Condition
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
        most.dejarPedido();
        }

    }
}
