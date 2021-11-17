package parcial2_Lusso_2908.Act2;

import Act4.Pista;

public class ParejaDeBaile implements Runnable {

    private int cantGrupos;
    private PistaBaile p;

    public ParejaDeBaile(PistaBaile p,int cant)
    {
        this.p = p;
        cantGrupos = cant;
    }

    public void run()
    {

        for(int i = 0;i < cantGrupos;i++)
        {
            //Espera a que se conforme la pareja
            p.iniciaBaile();
            //Se baila
            System.out.println("La pareja baila");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            //se desarma la pareja
            p.finBaile();
        }

    }
}
