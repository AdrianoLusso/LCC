package Act2;

public class Embotellador implements Runnable {
    private Fabrica f;
    public Embotellador (Fabrica f){
        this.f=f;
    }
    public void run (){
        int i=0;
        while (i<50){
            try {
               
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            f.embotellar();
            i++;
        }
    }
}