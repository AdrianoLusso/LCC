package Act2;
public class Mozo implements Runnable {
    
    private Comedor comedor;
    private int cantEmpleadosAAtender;

    public Mozo (Comedor comedor,int cant)
    {
        this.comedor = comedor;
        cantEmpleadosAAtender = cant;
    }

    public void permitePaso()
    {

    }

    public void run (){

        for(int i = 0;i < cantEmpleadosAAtender;i++)
        {
            System.out.println ("Inventando recetas");

            //!!!ESPERA ACTIVA.Hasta pasaMozo, atributo de comedor, no  sea true, se encotrara en espera activa.
            while(!comedor.getPasaMozo())
            {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            comedor.empezarACocinar();

            System.out.println("Preparando comida...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            comedor.servirComida();
        }
    }
}