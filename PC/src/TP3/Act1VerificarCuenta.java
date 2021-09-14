import java.util.logging.Level;
import java.util.logging.Logger;

public class Act1VerificarCuenta implements Runnable{

    private Act1CuentaBanco cb = new Act1CuentaBanco();

    private void HacerRetiro(int cantidad)throws InterruptedException
    {
        if (cb.getBalance() >= cantidad)
        {
        System.out.println ( Thread.currentThread().getName() + " está realizando" +
        " un retiro de: " + cantidad + ".");
        Thread.sleep(1000);
        cb.retiroBancario(cantidad);
        System.out.println(Thread.currentThread().getName() +": Retiro " +
        "realizado.");
         System.out.println(Thread.currentThread().getName() +": Los fondos " +
        "son de: " + cb.getBalance());
        }
         else
        {
        System.out.println("No hay suficiente dinero en la cuenta para"+
        " realizar el retiro Sr." +
         Thread.currentThread().getName());
        System.out.println("Su saldo actual es de " +
        cb.getBalance());
        Thread.sleep(1000);
        }
    }

// de hacer retiro

    public void run()
    {
        for (int i = 0; i <= 3; i++)
        {
            try 
            {
                this.HacerRetiro(10);
                if(cb.getBalance() < 0)
                {
                    System.out.println("La cuenta está sobregirada:" + Thread.currentThread().getName());  
                }
            } catch (InterruptedException ex) 
            {
                Logger.getLogger(Act1VerificarCuenta.class.getName());
                log(Level.SEVERE, null, ex); 
            }
        }
    }

    private void log(Level severe, Object object, InterruptedException ex) {
    }
}

    