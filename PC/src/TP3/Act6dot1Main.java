public class Act6dot1Main {
    
    public static void main(String[] args)
    {
        Act6Auto autoUno = new Act6Auto(1, 2000, 1000);
        Act6Auto autoDos = new Act6Auto(2, 2000, 500);
        Act6Auto autoTres = new Act6Auto(3, 2000, 2000);
        Act6Auto autoCuatro = new Act6Auto(4, 2000, 750);
        Act6Auto autoCinco = new Act6Auto(5, 2000, 300);

        autoUno.setDistanciaARecorrer(1000);
        autoDos.setDistanciaARecorrer(500);
        autoTres.setDistanciaARecorrer(4000);
        autoCuatro.setDistanciaARecorrer(1000);
        autoCinco.setDistanciaARecorrer(5000);

        Thread uno = new Thread(autoUno,"uno");
        Thread dos = new Thread(autoDos,"dos");
        Thread tres = new Thread(autoTres,"tres");
        Thread cuatro = new Thread(autoCuatro,"cuatro");
        Thread cinco = new Thread(autoCinco,"cinco");
        uno.start();
        
        dos.start();
        tres.start();
        cuatro.start();
        cinco.start();

        /*deberia dar 165000
        */
    }
    
}

