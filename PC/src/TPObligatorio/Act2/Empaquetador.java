package Act2;

public class Empaquetador implements Runnable {
    private Fabrica f;
    public Empaquetador (Fabrica f){
        this.f=f;
    }
    public void run (){
        int i=0;
        while (i<50){
            f.empaquetar();
            try {
                System.out.println ("La caja se lleno, el empaquetador la toma, la sella y la almacena");
                Thread.sleep(2000);
            } catch (Exception e) {
                
            }
            f.reponerCaja();
            i++;
        }
        
      
    }
}

