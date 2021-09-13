
class Act2ThreadTesting{
    public static void main (String[] args){
        Thread miHilo= new Act2MiEjecucion();
        miHilo.start();
      
        try {
            miHilo.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("En el main");
    }

    /*
    A pesar de ejecutar multiples veces,siempre se imprimia el main antes que la pila.

    Aun asi,podria darse que suceda el sout de miHilo antes que el del main.Para lograr determinismo,podria
    usar un miHilo.join(),lo que asegurara que antes de seguir ejecutando el main,se terminara la ejecucion de
    miHilo.
    */
}