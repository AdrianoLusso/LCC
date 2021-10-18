 public class Perro implements Runnable {
    private Comedor c;
    public Perro (Comedor c){
        this.c=c;
    }
    public void run (){

        c.ingresarAComerPerro();
        System.out.println (Thread.currentThread().getName()+ "comiendo.......");
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        c.liberarPlatoPerro();
    }
}
