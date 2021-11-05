package Act3;

import java.util.concurrent.Semaphore;

public class centroImpresion {
    
    int cantA,cantB;

    public centroImpresion(int cantA, int cantB)
    {
        this.cantA = cantA;
        this.cantB = cantB;
    }

    public synchronized void salir(char tipo)
    {
        //Se ve que tipo de impresora se libera.
        if(tipo == 'a')
        {
            cantA++;
            System.out.println(Thread.currentThread().getName() + " libera la impresora A.Quedan " +cantA);

        }
        else
        {
            cantB++;
            System.out.println(Thread.currentThread().getName() + " libera la impresora B.Quedan " +cantB);

        }

        this.notifyAll();
    }

    public synchronized char entrar(char tipo)
    {
        boolean entro = false,esC = (tipo == 'c');

        //Llega a la recepcion.
        do
        {
            //Se postula para impresora tipo a.
            if(tipo == 'a' || esC)
            {
                System.out.println(Thread.currentThread().getName()+ " se postula para impresora A.");

                //No hay impresoras libres.
                if(cantA == 0)
                {
                    if(!esC)
                    {
                        System.out.println(Thread.currentThread().getName()+ " debe esperar por impresora A.");

                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
                //Hay impresora libre.Entra.
                else
                {
                    entro = true;
                    cantA--;
                    System.out.println(Thread.currentThread().getName()+ " tiene una impresora tipo A.Quedan " +cantA);


                    if(esC)
                    {
                        tipo = 'a';
                    }
                }
            }
            
            //Se postula para impresora tipo a.
            if((tipo == 'b' || esC) && !entro)
            {
                System.out.println(Thread.currentThread().getName()+ " se postula para impresora B.");

                //No hay impresoras libres.
                if(cantB == 0)
                {
                    if(esC)
                    {
                        System.out.println(Thread.currentThread().getName()+ " debe esperar por alguna impresora.");
                    }
                    else
                    {
                        System.out.println(Thread.currentThread().getName()+ " debe esperar por impresora B.");

                    }
                    
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                //Hay impresora libre.Entra.
                else
                {
                    entro = true;
                    cantB--;
                    System.out.println(Thread.currentThread().getName()+ " tiene una impresora tipo B.Quedan " +cantB);


                    if(esC)
                    {
                        tipo = 'b';
                    }
                }
            }
        }while(!entro);

        return tipo;
    }

}
