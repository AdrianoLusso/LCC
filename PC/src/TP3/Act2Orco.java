
public class Act2Orco implements Runnable {
    
    private int danio;
    Act2Protagonista heroe;

    public Act2Orco(int danio,Act2Protagonista heroe)
    {
        this.danio = danio;
        this.heroe = heroe;
    }

    public void run(){     
            System.out.println(Thread.currentThread().getName() + " le quitara " + danio + 
            " al heroe...Ahora tiene:" + heroe.getVida());
            heroe.quitarVida(danio); 
            System.out.println(Thread.currentThread().getName() + " le quito " + danio + 
            " al heroe...Ahora tiene:" + heroe.getVida());              
    }

}
