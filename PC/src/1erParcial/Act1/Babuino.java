package Act1;
public class Babuino implements Runnable {
    
    //True: izquierda,False: derecha
    private boolean lado;

    //Recurso compartido: cuerda.
    private static Cuerda cuerda = new Cuerda();

    //Dice la cantidad total de babuinos registrados.
    private static int cantBabsTotal;

    public Babuino(boolean lado)
    {
        this.lado = lado;
        cantBabsTotal++;
    }

    public void run()
    {
        cuerda.empezarCruce();
        this.cruza();
        cuerda.terminarCruce(lado);
    }

    private void cruza()
    {
        /*
        Este metodo emula em tiempo en el que el babuino cruza por la cuerda.
        */
        System.out.println(Thread.currentThread().getName() + " esta cruzando.");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //Representa el cambio de lado
        lado = !lado;
    }

    public static void sensoFinal()
    {
        /*
        Este metodo realiza un senso final que notifica:
            La cantidad de babuinos que cruzaron desde el lado derecho.
            La cantidad de babuinos que cruzaron desde el lado izquierdo.
            Si,efectivamente,todos los babuinos cruzaron la vez que les corrrespondia.
        */
        System.out.println("Desde izquierda, cruzaron: " + cuerda.getCantBabsCruzaronDesdeIzq());
        System.out.println("Desde derecha, cruzaron: " + cuerda.getCantBabsCruzaronDesdeDer());

        if(cuerda.getCantBabsCruzaron() == cantBabsTotal)
        {
            System.out.println("Todos los babuinos cruzaron.");
        }
        else
        {
            System.out.println("No cruzaron todos los babuinos.");
        }
    }
}
