package Act4;
public class Act4Letra implements Runnable {
    private int turno;
    private char letra;
    private int reps;
    private static int cantItr= 20;
    private static Act4Impresora impresora = new Act4Impresora();
    
    public Act4Letra(char letra,int reps,int turno)
    {
        this.turno = turno;
        this.letra = letra;
        this.reps = reps;
    }

    public void run()
    {
        for(int i=0;i<cantItr;i++)
        {
            impresora.imprimir(letra,reps,turno);
        }
    }

}
