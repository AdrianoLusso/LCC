
class Act5MiHilo implements Runnable
{
    String nombreHilo;

    public Act5MiHilo(String nombre)
    {
        nombreHilo = nombre;
    }

    public void run()
    {
        System.out.println("Comenzando " + nombreHilo);


            for(int contar = 0;contar < 10;contar++)
            {
                System.out.println("En " +nombreHilo+ " reciento " + contar);
            }


        System.out.println("Terminando " + nombreHilo);
    }
}