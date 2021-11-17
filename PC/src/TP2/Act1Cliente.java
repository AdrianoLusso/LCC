package TP2;

public class Act1Cliente extends Thread{

    public void run()
    {
        System.out.println("soy "+ Thread.currentThread().getName());
        Act1Recurso.uso();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
        };
    }
}