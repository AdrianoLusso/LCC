package Act3;

public class Act3ControlTren implements Runnable {

    private Act3Tren tren;
    private int cantPasajerosHoy;

    public Act3ControlTren(Act3Tren tren,int cantPasajerosHoy)
    {
        this.tren = tren;
        this.cantPasajerosHoy = cantPasajerosHoy;
    }

    @Override
    public void run() 
    {
        //Ciclo
        for(int i = 0; i < cantPasajerosHoy;i++)
        {
            //Esperar a que una persona trate de entrar al tren.
            tren.iniciarControl();

            //Verificar si esa persona puede entrar tren.Si puede,pasa, sino lo hace esperar.
            tren.controlar();
        }
    }
    
}
