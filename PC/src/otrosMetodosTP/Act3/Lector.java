package otrosMetodosTP.Act3;

public class Lector implements Runnable {
    
    private Libro libro;
    private int hojasLeidas;

    public Lector(Libro libro)
    {
        this.libro = libro;
        hojasLeidas = 0;
    }

    public void run()
    {
        //Se fija si ya leyo todo el libro.Si no lo hizo,debe serguir leyendo o esperando.
        while(!libro.leidoCompleto(hojasLeidas))
        {
            //Ver si hay hojas nuevas por leer
            libro.esperarHojasNuevas(hojasLeidas);

            //Si no hay un escritor modificando el libro,lo lee.
            libro.empezarLectura();

            //Lee
            System.out.println(Thread.currentThread().getName()+" empezo a leer.");
            hojasLeidas = libro.leer(hojasLeidas);

            //Termina su posesion del libro.
            libro.terminarLectura();

            //Vuelve al inicio
        }

        System.out.println(Thread.currentThread().getName()+" termino el libro.");

    }
}
