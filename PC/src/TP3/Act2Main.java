public class Act2Main {
    
    public static void main (String[] args)
    {
        Act2Protagonista heroe = new Act2Protagonista();   
        Thread orco = new Thread(new Act2Orco(3, heroe),"Orco");
        Thread curandero = new Thread(new Act2Curandero(3, heroe),"Curandero");
        
        orco.start();
        curandero.start();

        try {
            orco.join();
            curandero.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        System.out.println("final " +heroe.getVida());
    }
}

/*
!!!PREGUNTAR PQ EL SLEEP AFECTA EN ESTOS CASOS
*/