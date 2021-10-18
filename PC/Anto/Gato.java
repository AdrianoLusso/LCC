public class Gato implements Runnable {
    private Comedor c;
    public Gato (Comedor c){
        this.c=c;
    }
    public void run (){

        c.ingresarAComerGato();
        System.out.println (Thread.currentThread().getName()+ "comiendo.......");
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        c.liberarPlatoGato();
    }
}


