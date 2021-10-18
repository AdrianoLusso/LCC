import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        int cant, cantPerros, cantGatos;
        Scanner leer= new Scanner (System.in);
        Thread [] perros, gatos;

        System.out.println ("Ingrese la cantidad de platos");
        cant= leer.nextInt();
        Comedor c= new Comedor (cant);
        System.out.println ("Ingrese la cantidad de perros");
        cantPerros= leer.nextInt();
        System.out.println ("Ingrese la cantidad de gatos");
        cantGatos= leer.nextInt();

        perros= new Thread [cantPerros];
        gatos= new Thread [cantGatos];

        for (int i =0;i<cantPerros; i++){
            perros[i]= new Thread (new Perro(c), "Perro".concat(Integer.toString(i)));
        }
        for (int i =0;i<cantGatos; i++){
            gatos[i]= new Thread (new Gato(c), "Gato".concat(Integer.toString(i)));
        }

        for (int i =0;i<cantPerros; i++){
            perros[i].start();
        }
        for (int i =0;i<cantGatos; i++){
            gatos[i].start();
        }





    }
    
}