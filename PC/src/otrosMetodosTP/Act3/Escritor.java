package otrosMetodosTP.Act3;

public class Escritor implements Runnable {
 
    private Libro libro;

    public Escritor(Libro libro)
    {
        this.libro = libro;
    }

    public void run()
    {
        //Pregunta cantidad de hojas escritas.Si no se termino el libro,escribe 1 hoja.
        while(!libro.libroTerminado())
        {
            //Toma el libro
            libro.empezarEscritura();

            //Escribe
            System.out.println(Thread.currentThread().getName()+" empezo a escribir.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            libro.escribir();

            //Deja el libro
            libro.terminarEscritura();

            //Vuelve inicio
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName()+" no debe seguir escribiendo");

    }
}
