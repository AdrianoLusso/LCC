package Act5;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Atraccion {
    
    boolean izqLibre,derLibre;
    Semaphore mutexControl = new Semaphore(1);
    Semaphore toboganes = new Semaphore(2);

    public Atraccion()
    {
        izqLibre = true;
        derLibre = true;
    }

    public void bajarTobogan(int toboganElegido)
    {
        try {
            mutexControl.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" bajo de su tobogan");
        //Se libera el tobogan.
        if(toboganElegido == 0)
        {
            derLibre = true;
        }
        else
        {
            izqLibre = true;
        }
        mutexControl.release();

        //Se le avisa al guardia que,efectivamente,se libero el tobogan.
        toboganes.release();
        
    }

    public int subirTobogan()
    {
        int toboganElegido;
        Random r = new Random();

        try {
            toboganes.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" entraa la cabina");
        try {
            mutexControl.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" entro al control..." +izqLibre+"-"+derLibre);

        if(izqLibre && derLibre)
        {
            System.out.println("se elegira por que tobgan va " +Thread.currentThread().getName());
            //Se decide con un random
            toboganElegido = r.nextInt(2);
            System.out.println(toboganElegido);

            if(toboganElegido == 0)
            {
                System.out.println(Thread.currentThread().getName()+" ira por derecha");
                //Se eligio el derecho
                derLibre = false;
            }
            else
            {
                System.out.println(Thread.currentThread().getName()+" ira por izquierda");
                //Se eligio el izquierdo
                izqLibre = false;
            }

        }   
        else
        {
            if(izqLibre)
            {
                //Solo el izq esta libre
                System.out.println(Thread.currentThread().getName()+" ira por izquierda");
                toboganElegido = 1;
                izqLibre = false;
            }
            else
            {
                //Solo el der esta libre  
                System.out.println(Thread.currentThread().getName()+" ira por derecha");
                toboganElegido = 0;
                derLibre = false;
            }
        }

        System.out.println(Thread.currentThread().getName()+" salio del control");
        mutexControl.release();

        return toboganElegido;
    }
}
