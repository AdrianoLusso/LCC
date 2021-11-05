package Act3;

public class Persona implements Runnable{

    private char tipo;
    private static centroImpresion centro = new centroImpresion(4, 2);


    public Persona(char tipo)
    {
        this.tipo = tipo;
    }

    @Override
    public void run() {

        //Entrar al centro.Es decir, ver si hay impresoras libres.
        tipo = centro.entrar(tipo);

        //Imprimir.
        try {
            System.out.println(Thread.currentThread().getName()+ " empieza a imprimir.");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+ " termina a imprimir.");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //Irse del centro.Es decir, liberar impresora.
        centro.salir(tipo);
    }
    
    
}
