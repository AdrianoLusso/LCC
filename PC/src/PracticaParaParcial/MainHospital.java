public class MainHospital {
    
    public static void main(String[] args)
    {
        int cantDeHilos = 10;
        Hospital hosp = new Hospital();
        Thread recep = new Thread(new Recepcionista(hosp,cantDeHilos),"recepcionista");
        Thread[] col = new Thread[cantDeHilos];

        for(int i = 0;i < cantDeHilos;i++)
        {
            col[i] = new Thread(new Donante(hosp),i+1+"");
        }

        recep.start();

        for(int i = 0;i < cantDeHilos;i++)
        {
            col[i].start();
        }

    }
}
