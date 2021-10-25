package Act1;

public class Act1DisparaSala 
{
    public static void main(String[] args) 
    {
        //Se crea el recurso compartido y los Runnables
        Act1Sala sala = new Act1Sala();
        Act1Fumador f1 = new Act1Fumador(1, sala);
        Act1Fumador f2 = new Act1Fumador(2, sala);
        Act1Fumador f3 = new Act1Fumador(3, sala);
        Act1Agente ag = new Act1Agente(sala);
    
        //Se crean los hilos.
        Thread fumador1 = new Thread(f1,"fumador 1");
        Thread fumador2 = new Thread(f2,"fumador 2");
        Thread fumador3 = new Thread(f3,"fumador 3");
        Thread agente = new Thread(ag,"agente");

        //Se inician los hilos
        fumador1.start();
        fumador2.start();
        fumador3.start();
        agente.start();
    }
}
