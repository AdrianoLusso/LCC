package Act1;
import java.util.Random;

public class Act1Agente implements Runnable 
{
    private Act1Sala sala;
    private Random r;

    public Act1Agente(Act1Sala sala)
    {
        this.sala = sala;
        r= new Random();
    }

    public void run ()
    {
        while(true)
        {
            sala.colocar(r.nextInt(3)+1);
        }
    }
}