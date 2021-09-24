public class Act6Surtidor {

    int cantLtsRestante;

    public Act6Surtidor(){
        cantLtsRestante = 200000;
    }

    public synchronized void llenar(Act6Auto auto,int cantLts)
    {       
        auto.llenarLts(cantLts);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        cantLtsRestante -= cantLts;
        System.out.println("El surtidor le esta cargando a " +Thread.currentThread().getName()+
        ". Nafta restante del surtidor: " + cantLtsRestante);
    }

}
