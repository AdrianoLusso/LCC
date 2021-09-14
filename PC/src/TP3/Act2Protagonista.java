

public class Act2Protagonista{

    private int vida = 10;

    public Act2Protagonista(){   
    }

    public int getVida() {
        return this.vida;
    }

    public synchronized void curarVida(int diferencia)
    {
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        vida =vida + diferencia;
    }

    public synchronized void quitarVida(int diferencia)
    {
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        vida = vida - diferencia;
    }
}