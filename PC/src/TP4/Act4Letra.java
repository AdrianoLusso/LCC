import java.util.concurrent.Semaphore;

public class Act4Letra implements Runnable {
    
    private Semaphore aAdquirir,aLiberar;
    private static int cantItr = 100;
    private int cantChars;
    private char letra;

    public Act4Letra(char letra,int cantChars,Semaphore aAdquirir,Semaphore aLiberar){
        this.letra = letra;
        this.cantChars = cantChars;
        this.aAdquirir = aAdquirir;
        this.aLiberar = aLiberar;
    }

    public void run()
    {
        int itrRestantes = cantItr;

        for(int i = 0;i < itrRestantes;i++)
        {
            try {
            aAdquirir.acquire();
            Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    
            for(int j = 0;j < cantChars;j++)
            {
                System.out.print(letra);
            }

            if(letra == 'C')
            {
                System.out.println("");
            }
            aLiberar.release();
        }
        
    }

}
