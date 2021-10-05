public class Recepcionista implements Runnable {
    
    private Hospital hospital;
    private int cantDonantesPorHoy;

    public Recepcionista(Hospital hosp,int cant)
    {
        hospital = hosp;
        cantDonantesPorHoy = cant;
    }

    public void run()
    {
        for(int i = 0;i<cantDonantesPorHoy;i++)
        {
            //Esperar a recibir llamado
            hospital.atender();

            //Registrar donante interesado
            this.registrarDonante();

            //Cortar llamada
            System.out.println("Corto la llamada");
            hospital.cortar();

        }
    }

    public void registrarDonante()
    {
        System.out.println(Thread.currentThread().getName() + " esta anotando a un donante interesado.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
