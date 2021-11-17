package parcial2_Lusso_2908;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Mostrador {
    
    //Cantidad de pedidos de hoy,y el arreglo de estos.
    private int cantPedidosHoy;
    Pedido[] pedido;

    //Controla el proceso de dejar y tomar ordenes de pedido.
    private ReentrantLock entregaPedido = new ReentrantLock();
    private int cantPedidosNap = 0,cantPedidosVeg = 0;
    private Condition hayOrdenNap = entregaPedido.newCondition();
    private Condition hayOrdenVeg = entregaPedido.newCondition();

    //Controla el proceso de ver si hay,o no,espacio en el mostrador.
    private ReentrantLock mostrador = new ReentrantLock();
    private int espacio,pedidosEnMostr = 0;
    Condition hayEspacio = mostrador.newCondition();
    Condition hayPedido = mostrador.newCondition();


    public Mostrador(int MAX,int cant)
    {
        espacio = MAX;
        cantPedidosHoy = cant;
        pedido = new Pedido[cant];
    }

    public Pedido tomarPedido()
    {
        boolean continuar = false;
        int i = 0;
        Pedido ped = null;

        mostrador.lock();

        //Mira a ver si hay pedido en mostrador
        do
        {
            if(pedidosEnMostr == 0)
            {
                //No hay pedido.Espera
                try {
                    hayPedido.await();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            else
            {
                //Hay pedido,va a tomarlo.
                pedidosEnMostr--;
                continuar = true;
            }
        }while(continuar);

        //Toma un pedido de los de estado 2 del mostrador.
        do
        {
            if(pedido[i] != null && pedido[i].getEstado() == 2)
            {
                ped = pedido[i];
                pedido[i] = null;
            }
            else
            {
                i++;
            }
        }while(ped == null);

        mostrador.unlock();

        return ped;
    }

    public void enviarOrden(int nroPed,Pedido ped)
    {
        //Se almacena el pedido en la base de datos.
        pedido[nroPed] = ped;

        //De acuerdo al tipo de pedido, se le notifica a un respectivo pizero.
        if(pedido[nroPed].getTipo())
        {
            hayOrdenNap.signal();
        }
        else
        {
            hayOrdenVeg.signal();
        }
        
    }

    public void dejarPedido(boolean tipo)
    {
         /*
        El enunciado no pide que haya una diferencia de comportamiento,segun el pedido, a la hora
        de tomarlo del mostrador.Solo se toma 1,y se lo lleva al cliente.
        */

        int i = 0;

        mostrador.lock();

        //Se actualiza el estado del pedido a estado 2.Por como esta armado el programa,si o si se
        //lograra actualizar un pedido.
        do
        {
            if(pedido[i] != null && pedido[i].getTipo() == tipo && pedido[i].getEstado() == 1)
            {
                pedido[i].aumentarEstado();
            }
            else
            {
                i++;
            }
        }while(pedido[i].getEstado() == 1);


        //Se deja el pedido en el mostrador.
        pedidosEnMostr++;

        //Se avisa,si hay repartidor durmiendo, para que vea el pedido.
        hayPedido.signal();

        mostrador.unlock();
    }

    public void empezarPedido()
    {
        /*
        Este metodo esta diseniado para que NO QUEDEN PIZEROS ESPERANDO CON PIZAS EN LA MANO.
        Sino que,antes de empezar a armarla,reservan un lugar del mostrador para asegurarse que,
        cuando terminen de hacer su piza,tengan lugar en este. Lo disenie asi porque considere que
        seria un proceso mas eficiente para el funcionamiento de este dominio, ya que hacer esperar
        a pizeros con pizas en la mano, seria un error de organizacion en la cocina.
        */
        boolean continuar= false;

        mostrador.lock();

        //Se verifica si hay espacio en el mostrador
        do
        {
            if(espacio == 0)
            {
                //No hay espacio,debe esperar.
                try {
                    hayEspacio.await();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            else
            {
                //Hay espacio,lo reserva para cuando deba dejar su piza.
                espacio--;
                continuar = true;
            }
        }while(!continuar);

        mostrador.unlock();
    }

    public void esperarPedido(boolean tipo)
    {
        boolean continuar = false;
        int i = 0;

        entregaPedido.lock();

        //Se verifica si hay pedidos del tipo que le corresponde
        do
        {
            if(tipo)
            {
                //tipo nap
                if(cantPedidosNap == 0)
                {
                    //no hay pedidos,espera
                    try {
                        hayOrdenNap.await();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                else
                {
                    //si hay pedidos,lo toma
                    cantPedidosNap--;
                    continuar = true;
                }
            }
            else
            {
                //tipo veg
                if(cantPedidosVeg == 0)
                {
                    // no hay pedidos,espera
                    try {
                        hayOrdenVeg.await();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                else
                {
                    //si hay pedidos,lo toma
                    cantPedidosVeg--;
                    continuar = true;

                }
            }
        }while(!continuar);

        entregaPedido.unlock();
    }



}
