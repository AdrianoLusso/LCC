public class MainComedor {

    public static void main(String[] args)
    {
        int cantDePerros = 2;
        int cantDeGatos = 3;
        Thread[] col = new Thread[(cantDeGatos+cantDePerros)];

        Thread a = new Thread(new Animal('g'),"a");
        Thread b = new Thread(new Animal('g'),"b");
        Thread c = new Thread(new Animal('g'),"c");

        /*
        a.start();
        b.start();
        c.start();*/

        
        for(int i = 0; i < cantDePerros; i++)
        {
            col[i] = new Thread(new Animal('p'),i+1+" - perro");
        }

        for(int i = cantDePerros;i < (cantDeGatos+cantDePerros);i++)
        {
            col[i] = new Thread(new Animal('g'),i+1+" - gato");
        }

        for(int i = 0;i < (cantDeGatos + cantDePerros); i++)
        {
            col[i].start();
        }
    }
    
}

