
public class Act2Curandero implements Runnable {
    
    private int curacion;
    Act2Protagonista heroe;

    public Act2Curandero(int curacion,Act2Protagonista heroe)
    {
        this.curacion = curacion;
        this.heroe = heroe;
    }

    public void run(){
        System.out.println(Thread.currentThread().getName() + " le curara " + curacion + 
        " al heroe...Ahora tiene:" + heroe.getVida());
        heroe.curarVida(curacion); 
        System.out.println(Thread.currentThread().getName() + " le curo " + curacion + 
        " al heroe...Ahora tiene:" + heroe.getVida());           
    }
}

