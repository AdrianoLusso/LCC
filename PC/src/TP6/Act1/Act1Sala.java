package Act1;
public class Act1Sala {
    
    private int idActual;

    //Cumple un funcionamiento parecido al de un semaforo con rendesvouz.
    private boolean terminoDeFumar;
    private boolean mesaRepuesta;

    public Act1Sala()
    {
        //Evita que algun fumador pueda fumar antes de que el agente setee el id a 1,2 o 3.
        idActual = 0;

        //Se asume que ningun fumador termino de fumar aun, y que la mesa aun no se repuso.
        terminoDeFumar = false;
        mesaRepuesta = false;
    }

    public synchronized void entraFumar(int id)
    {
        boolean seguir = false;

        //Se loopea hasta que coincidan los id's.
        do
        {
            if(idActual != id)
            {
                try {
                    System.out.println(Thread.currentThread().getName() + " debe esperar su turno.");
                    this.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            else
            {
                System.out.println(Thread.currentThread().getName() + " ya puede fumar.");
                seguir = true;
            }
        }while(!seguir);

        //Toma los ingredientes, y la esa volvio a estar vacia.
        mesaRepuesta = false;
    }

    public synchronized void terminaFumar()
    {
        boolean seguir=false;

        System.out.println(Thread.currentThread().getName() + " termino de fumar.");
        terminoDeFumar = true;
        this.notifyAll();

        //Se loopea hasta que la mesa haya sido repuesta.
        do
        {
            if(!mesaRepuesta)
            {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            else
            {
                seguir = true;
            }
        }while(!seguir);
    }

    public synchronized void colocar(int nuevoId)
    {
        boolean seguir = false;

        //El agente selecciona que fumador le toca fumar.
        System.out.println(Thread.currentThread().getName() + " repone la mesa");
        idActual = nuevoId;
        this.notifyAll();

        //Se loopea hasta que el fumador actual haya terminado de fumar.
        do
        {
            if(!terminoDeFumar)
            {
                System.out.println(Thread.currentThread().getName() + " debe esperar a que el fumador actual termine.");
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            else
            {
                System.out.println(Thread.currentThread().getName() + " puede reacomodar la mesa.");
                seguir = true;
            }
        }while(!seguir);

        //Se repuso la mesa.
        terminoDeFumar = false;
        mesaRepuesta = true;
    }
}
