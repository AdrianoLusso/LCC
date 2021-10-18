package Act1;
public class Parque {
    
    public static void main(String[] args)
    {
        //Setee aqui la cantida de babuinos de lado izquierdo y derecho
        int izq = 0,der = 0;
        Thread[] babs = new Thread[izq+der];

        //Creo los babuinos del lado izquierdo
        for(int i = 0; i < izq; i++)
        {
            babs[i] = new Thread(new Babuino(true),i+1 +"");
        }


        //Creo los babuinos del lado derecho
        for(int i = izq; i < der+izq; i++)
        {
            babs[i] = new Thread(new Babuino(false),i+1 +"");
        }

        //Inicio los hilos
        for(int i = 0; i < izq+der; i++)
        {
            babs[i].start();;
        }

        //Obligo al main a esperar a que todos los hilos finalicen antes de hacer el senso de babuinos.
        for(int i = 0; i < izq+der; i++)
        {
            try {
                babs[i].join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        //Realizo las verificaciones finales.
        Babuino.sensoFinal();
    }
}
