

import java.util.concurrent.Semaphore;

public class Comedor {
    private int cantidadPlatos;
    private char comiendo;
    private Semaphore mutex, platosP, platosG, rendezvous;
    private int cantPerrosEsperando,cantGatosEsperando,cantPerrosComiendo,cantGatosComiendo;

    public Comedor (int cantPlatos){
        this.cantidadPlatos=cantPlatos;
        this.comiendo=randomIngreso();
        System.out.println ("Empiezan a comer-------->"+comiendo);
        this.rendezvous=new Semaphore (0);
        this.mutex=new Semaphore (1);
        this.platosP=new Semaphore (cantPlatos);
        this.platosG=new Semaphore (cantPlatos);
    }
    public char randomIngreso (){
        char com='G';
        if ((int)Math.random()*11%2==0){
            com='P';
        }
        return com;
    }
    public void ingresarAComerPerro(){
        try {
            mutex.acquire();
            if (comiendo =='P'){
                mutex.release();

            }else{
                System.out.println (Thread.currentThread().getName() +" no pudo ingresar, espera");
                cantPerrosEsperando++;
                mutex.release();
                //espera que el ultimo gato que se vaya le libere el permiso
                rendezvous.acquire();

                mutex.acquire();
                cantPerrosEsperando--;
                mutex.release();
                System.out.println (Thread.currentThread().getName() +" puede agarrar un plato");
            }
            platosP.acquire();
            incrementarCantPerroComiendo();
        } catch (Exception e) {}

    }
    public void incrementarCantPerroComiendo(){
        try {
            mutex.acquire();
            System.out.println("Perros antes, " +cantPerrosComiendo);
            cantPerrosComiendo++;
            System.out.println(Thread.currentThread().getName() + " esta comiendo.Ahora hay " +cantPerrosComiendo);
            mutex.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void ingresarAComerGato(){
        try {
            mutex.acquire();
            if (comiendo =='G'){
                mutex.release();
            }else{
                System.out.println (Thread.currentThread().getName() +" no pudo ingresar, espera");
                cantGatosEsperando++;
                mutex.release();
                //espera que el ultimo perro que se vaya le libere el permiso
                rendezvous.acquire();

                mutex.acquire();
                cantGatosEsperando--;
                mutex.release();
                System.out.println (Thread.currentThread().getName() +" puede agarrar un plato");
            }
            platosG.acquire();
            incrementarCantGatoComiendo();
        } catch (Exception e) {}

    }
    public void incrementarCantGatoComiendo(){
        try {
            mutex.acquire();
            System.out.println("Gatos antes, " +cantGatosComiendo);
            cantGatosComiendo++;
            System.out.println(Thread.currentThread().getName() + " esta comiendo.Ahora hay " +cantGatosComiendo);
            mutex.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    public void liberarPlatoPerro(){
        try {
            //acquire de mutex para 

            mutex.acquire();

            System.out.println (Thread.currentThread().getName()+ "deja el plato y se va ");
            cantPerrosComiendo--;
            System.out.println (Thread.currentThread().getName()+ "efectivamente se fue.Ahora hay " +cantPerrosComiendo);

            if (cantGatosEsperando>=1){
               
                mutex.release();
                comiendo='G';

                if(cantPerrosComiendo == 0)
                {
                    rendezvous.release(cantidadPlatos);
                    platosG.release(cantidadPlatos);
                }
                      
            }else{
                platosP.release();
                if (cantGatosEsperando==0 && cantPerrosEsperando>=1){
                    rendezvous.release();
                }
                mutex.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void liberarPlatoGato(){
        try {
            mutex.acquire();

            System.out.println (Thread.currentThread().getName()+ "deja el plato y se va ");
            cantGatosComiendo--;
            System.out.println (Thread.currentThread().getName()+ "efectivamente se fue.Ahora hay " +cantGatosComiendo);

            if (cantPerrosEsperando>=1){
                
                mutex.release();
                comiendo='P';

                if(cantGatosComiendo == 0)
                {
                    rendezvous.release(cantidadPlatos);
                    platosP.release(cantidadPlatos);
                }
            }else{
                platosG.release();
                if (cantPerrosEsperando==0 && cantGatosEsperando>=1){
                    rendezvous.release();
                }
                mutex.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}