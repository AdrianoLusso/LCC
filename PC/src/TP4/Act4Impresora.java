import java.util.concurrent.Semaphore;

public class Act4Impresora {
    
    private Semaphore sem1,sem2,sem3;

    public Act4Impresora()
    {
        sem1 = new Semaphore(1);
        sem2 = new Semaphore(0);
        sem3 = new Semaphore(0);
    }

    private Semaphore[] detectarTurno(int turno)
    {
        Semaphore[] arr = new Semaphore[2];
        
        switch(turno)
        {
            default:
                arr[0] = sem1;
                arr[1] = sem2;
                break;
            case 2:
                arr[0] = sem2;
                arr[1] = sem3;
                break;
            case 3:
                arr[0] = sem3;
                arr[1] = sem1;
                break;
        }

        return arr;
    }

    public void imprimir(char letra,int reps, int turno)
    {

        Semaphore[] arr = detectarTurno(turno);

         try {
            arr[0].acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        for(int i = 0; i < reps;i++)
        {
            System.out.print(""+letra);
        }

        arr[1].release();
    }
}
