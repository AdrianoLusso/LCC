

public class Act1TesteoRecurso{

    public static void main (String[] args){
        
        Act1Cliente juan = new Act1Cliente();
        juan. setName("Juan Lopez");

        Act1Cliente ines = new Act1Cliente();
        ines.setName("ines Garcia");

        juan.start();
        ines.start();
    }

    /*
    Observe las siguientes posibilidades de ejecucion:
    soy Juan Lopez
    soy ines Garcia
    en Recurso: Soy Juan Lopez
    en Recurso: Soy ines Garcia

    soy Juan Lopez
    soy ines Garcia
    en Recurso: Soy ines Garcia
    en Recurso: Soy Juan Lopez 

    soy ines Garcia
    soy Juan Lopez
    en Recurso: Soy ines Garcia
    en Recurso: Soy Juan Lopez 

    soy ines Garcia
    soy Juan Lopez
    en Recurso: Soy Juan Lopez
    en Recurso: Soy ines Garcia

    El metodo uso nos permite ver si,en el trancurso del primer thread que haya estado en estado run(sea
    juan o ines),el procesador no decidio llevar el thread a ready y traer el otro thread a run.Por ejemplo:
    Podria estar Juan en ready,pero antes de llegar a su invocacion de uso,se cambia a Ines como run thread.
    Asi,se obtienen las combinaciones antes mencionadas.
    */
}