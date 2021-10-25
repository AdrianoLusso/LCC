package Act1;
public class Act1Fumador implements Runnable{
    private int id;
    private Act1Sala sala;

    public Act1Fumador(int id, Act1Sala sala)
    {
        this.id = id;
        this.sala = sala;
    }
    
    public void run()
    {
        while(true)
        {
            try {
                sala.entraFumar(id);;

                System.out.println("fumador " +id+ " esta fumando.");
                Thread.sleep(1000);

                sala.terminaFumar();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}