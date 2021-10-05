public class Act9Hamster implements Runnable {
    
    private static Act9Jaula jaula = new Act9Jaula();

    public Act9Hamster()
    {

    }

    public void run()
    {
        boolean comio = false, corrio = false,durmio = false;

        do
        {
        
        //Comer
        if(!comio)
        {
            comio = jaula.comer();
        }
       

        //Correr
        if(!corrio)
        {
            corrio = jaula.correr();
        }

        //Descansar
        if(!durmio)
        {
            durmio = jaula.dormir();
        }
        
        }while(!comio || !corrio || !durmio);

    }
}
