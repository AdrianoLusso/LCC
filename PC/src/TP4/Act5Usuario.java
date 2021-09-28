public class Act5Usuario implements Runnable {
    
    //Consideraremos tipo - a las que no necesitan un tipo especifico
    private char tipoImpNecesaria;

    public static void generarImpresoras(int cantImpA,int cantImpB)
    {
    }

    public Act5Usuario(char tipo)
    {

        this.tipoImpNecesaria = tipo;
        
    }

    public void run()
    {
        //Emula el tiempo en el que el usuario genera su trabajo
        try {
            System.out.println(Thread.currentThread().getName() + ": generando trabajo...");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //Va a imprimir
        centro.irAImprimir(tipoImpNecesaria);
    }

}
