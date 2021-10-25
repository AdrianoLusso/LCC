package Act2;

import java.util.concurrent.Semaphore;

public class Fabrica {
    
    private Semaphore semEmb, semCaja, mutex;
    private int cantBotellas;

    public Fabrica(){
        cantBotellas=0;
        semEmb= new Semaphore (0);
        semCaja= new Semaphore(0);
        mutex=new Semaphore(1);
    }
    public void embotellar (){
        try {
            mutex.acquire();
            System.out.println ("Embotellando...");
            cantBotellas++;
            if (cantBotellas%10==0){
                semEmb.release();
                mutex.release();
                semCaja.acquire();
            }else{  mutex.release();}
       
            
        } catch (Exception e) {
            e.printStackTrace();
        }
     

    }
    public void empaquetar (){
        try {
            //espera la señal de que la caja se lleno
            semEmb.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void reponerCaja (){
        semCaja.release();
        System.out.println ("El empaquetador repone caja");
    }
}