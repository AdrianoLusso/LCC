class Act3MiHilo implements Runnable{
    
    Thread hilo;
    static Act3SumaMatrizBlockSynch sumaM= new Act3SumaMatrizBlockSynch();
    int[] arr;
    int resp;

    //Construye un nuevo hilo.
    Act3MiHilo(String nombre, int[] nums)
    {
        hilo= new Thread(this,nombre);
        arr=nums;
    }

    //Un método que crea e inicia un hilo
    public static Act3MiHilo creaEInicia (String nombre,int[] nums)
    {
        Act3MiHilo miHilo=new Act3MiHilo(nombre,nums);
        miHilo.hilo.start(); //Inicia el hilo
        return miHilo;
    }

    //Punto de entrada del hilo
    public void run()
    {
        int sum;
        System.out.println(hilo.getName()+ " iniciando.");
        sum=sumaM.sumMatriz(arr);
        System.out.println("Suma para "+hilo.getName()+ " es "+sum);
        System.out.println(hilo.getName()+ " terminado.");
    }
}
    