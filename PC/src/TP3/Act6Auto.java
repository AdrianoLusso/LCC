public class Act6Auto implements Runnable {
    
    private int patente;
    private double distanciaARecorrer;
    private int kmFaltanteService;
    private double naftaLts;
    private static Act6Surtidor surtidor = new Act6Surtidor();
    
    public Act6Auto(int patente,int kmFaltanteService,int naftaLts)
    {
        this.kmFaltanteService = kmFaltanteService;
        this.naftaLts = naftaLts;
        this.patente = patente;
        this.distanciaARecorrer = 0;
    }

    public double getDistanciaARecorrer()
    {
        return distanciaARecorrer;
    }

    public void setDistanciaARecorrer(int dist)
    {
        distanciaARecorrer = dist;
    }
    
    @Override
    public void run() {
        // TODO Auto-generated method stub
        this.andar();
    }

    public void llenarLts(int cant)
    {
        naftaLts += cant;
    }

    public void andar()
    {
        double kmPorControl = distanciaARecorrer / 20;
        double naftaPorControl = kmPorControl * 2;

        while(distanciaARecorrer > 0)
        {
            
            if(naftaLts > 500)
            {           
                distanciaARecorrer =distanciaARecorrer - kmPorControl;
                naftaLts = naftaLts - naftaPorControl;

                System.out.println("El auto " +Thread.currentThread().getName()+ " siguio su " + 
                " camino por " +kmPorControl+" km mas.Nafta restante: " + naftaLts);

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }            
            }
            else{
                distanciaARecorrer =distanciaARecorrer - kmPorControl;
                naftaLts = 0;

                System.out.println("El auto " +Thread.currentThread().getName()+ " fue a cargar nafta." + 
                "Nafta restante: " + naftaLts);

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                surtidor.llenar(this,5000);
                System.out.println("El auto " + Thread.currentThread().getName() + " termino de cargar nafta.");
            }
        }
    }
}
