package Act5;
public class Act5Usuario implements Runnable {

    public static Act5Centro centro = new Act5Centro(3,2);
    char tipo;

    public Act5Usuario(char ti)
    {
        tipo = ti;
    }

    public void run()
    {
        boolean constancia;

        //Generar trabajo
        System.out.println(Thread.currentThread().getName() + " genera su trabajo.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //Solicitar impresion
        constancia = centro.solicitarImpresion(tipo);

        //Ir a imprimir con la respectiva solicitud
        centro.imprimir(constancia);
    }
}
