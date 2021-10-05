public class Act7Taxista implements Runnable {
    
    private Act7Taxi taxi;

    public Act7Taxista(Act7Taxi taxi)
    {
        this.taxi = taxi;
    }

    @Override
    public void run() {
        while(true)
        {
            //Duerme hasta que le piden hacer un viaje
            taxi.empezarAConducir();

            //conduce
            this.conducir();

            //notifica que llego al destino 
            taxi.terminarDeConducir();  
        }
    }

    private void conducir()
    {
        System.out.println("Taxista esta conduciendo");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
