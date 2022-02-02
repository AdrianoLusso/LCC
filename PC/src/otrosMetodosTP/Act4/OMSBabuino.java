package otrosMetodosTP.Act4;

public class OMSBabuino implements Runnable {
    
    //True: izquierda,False: derecha
    private boolean lado;

    //Recurso compartido: cuerda.
    private OMSCuerda cuerda;

    public OMSBabuino(OMSCuerda c, boolean lado)
    {
        cuerda = c;
        this.lado = lado;
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
        Este metodo emula en tiempo en el que el babuino cruza por la cuerda.
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
}
