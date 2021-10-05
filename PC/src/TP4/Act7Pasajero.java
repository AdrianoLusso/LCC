public class Act7Pasajero implements Runnable {
    
    private Act7Taxi taxi;

    public Act7Pasajero(Act7Taxi taxi)
    {
        this.taxi = taxi;
    }

    public void run()
    {
        //Busca un taxi
        this.buscarTaxi();

        //Encuentra al taxi y le dice que a donde viajar
        taxi.entrarAlTaxi();

        //Esperar que termine el viaje, y sale del taxi
        taxi.salirDelTaxi();
    }

    public void buscarTaxi()
    {
        System.out.println(Thread.currentThread().getName() + " busca el taxi");
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
