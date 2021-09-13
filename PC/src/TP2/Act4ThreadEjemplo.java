
public class Act4ThreadEjemplo implements Runnable
{
    String str;

    public Act4ThreadEjemplo(String str)
    {
        this.str = str;
    }

    public void run()
    {
        for(int i = 0;i < 10;i++)
        {
            System.out.println(i + " " + str);        
        }
        System.out.println("Termina thread ");
    }

    public static void main (String [] args)
    {
        new Thread(new Act4ThreadEjemplo("Maria Jose")).start();
        new Thread(new Act4ThreadEjemplo("Jose Maria")).start();
        System.out.println("Termina thread main");
    }
}

/*En este caso si,ya que hay informacion que debe ser impresa,y es necesario pasarla por parametro
de alguna forma.
*/