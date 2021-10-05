package Act5;
import java.util.concurrent.Semaphore;

public class Act5Centro {
    
    public static int cantADisp,cantBDisp;
    public static Semaphore semEsperarB = new Semaphore(1),semEsperarA = new Semaphore(1),
    semMutexA = new Semaphore(1),semMutexB = new Semaphore(1);

    public Act5Centro(int cantA,int cantB)
    {
        cantADisp = cantA;
        cantBDisp = cantB;
    }

    public void imprimir(boolean cons)
    {
        if(cons)
        {
            this.imprimirA();
        }
        else
        {
            this.imprimirB();
        }
    }

    private static void imprimirA()
    {
        System.out.println(Thread.currentThread().getName() + " esta imprimiendo en imp A");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " termino");

        //Exclusion mutua sobre cantADisp
        try {
            semMutexA.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if(cantADisp == 0)
        {
            semEsperarA.release();
        }
        
        cantADisp++;
        semMutexA.release();   
    }

    private static void imprimirB()
    {
        System.out.println(Thread.currentThread().getName() + " esta imprimiendo en imp B");
       
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " termino");

        //Exclusion mutua sobre cantBDisp
        try {
            semMutexB.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if(cantBDisp == 0)
        {
            semEsperarB.release();
        }

        cantBDisp++;
        semMutexB.release();    
    }

    public boolean solicitarImpresion(char tipo)
    {
        boolean constancia;

        if(tipo == 'A')
        {
            constancia = true;
            this.verificarDispA();
        }
        else
        {
            constancia = false;
            this.verificarDispB();
        }

        

        return constancia;
    }


    private void verificarDispA()
    {
        try {
            semMutexA.acquire();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
         if(cantADisp <= 1)
         {
             semMutexA.release();
             try {
                semEsperarA.acquire();
                semMutexA.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
         }

        cantADisp--;
        semMutexA.release();
    }

    private void verificarDispB()
    {        

        //Exclusion mutua sobre cantBDisp
        try {
            semMutexB.acquire();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }

       if(cantBDisp <= 1)
        {
            semMutexB.release();
            //Todas las impresoras B llenas.Debe esperar.
            try {
                semEsperarB.acquire();
                semMutexB.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        cantBDisp--;
        semMutexB.release();
    }

    private void verificarDispAAA()
    {

        //Exclusion mutua sobre cantADisp
        try {
            semMutexA.acquire();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        int c = cantADisp;
        System.out.println(Thread.currentThread().getName() + " c: " + c);
        semMutexA.release();
        
        if(c <= 1)
        {
            //Todas las impresoras A llenas.Debe esperar.
            try {
                semEsperarA.acquire();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        try {
            semMutexA.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        cantADisp--;
        semMutexA.release();
    }

    private void verificarDispBbbb()
    {        

        //Exclusion mutua sobre cantBDisp
        try {
            semMutexB.acquire();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        int c = cantBDisp;
        System.out.println(Thread.currentThread().getName() + " c: " + c);
        semMutexB.release();

       if(c <= 1)
        {
            //Todas las impresoras B llenas.Debe esperar.
            try {
                semEsperarB.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            semMutexB.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        cantBDisp--;
        semMutexB.release();
    }

}