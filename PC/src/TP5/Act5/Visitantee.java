package Act5;

public class Visitantee implements Runnable{
  
    private int tobogan = 0;
    private static Atraccion atraccion = new Atraccion();

    public Visitantee()
    {

    }

    public void run()
    {
        int t;

        //Sube al tobogan
        tobogan = atraccion.subirTobogan();

        //Se desliza
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(tobogan == 0)
        {
            System.out.println(Thread.currentThread().getName()+" se esta deslizando por la derecha");

        }
        else
        {
            System.out.println(Thread.currentThread().getName()+" se esta deslizando por la izquierda");

        }

        //Baja
        atraccion.bajarTobogan(tobogan);
    }
}
