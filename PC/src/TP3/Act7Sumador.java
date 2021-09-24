public class Act7Sumador implements Runnable {

    private int ini;
    private int fin;
    private int[] arr;
    private static Act7Resultado resultadoFinal = new Act7Resultado();

    public Act7Sumador(int ini,int fin,int[] arr){
        this.ini = ini;
        this.fin = fin;
        this.arr = arr;
    }

    @Override
    public void run() {

        System.out.println("Hilo " + Thread.currentThread().getName() + " inicio su suma parcial.");
        for(int i = ini;i <= fin;i++)
        {
            resultadoFinal.sumar(arr[i]);
        }   
        System.out.println("Hilo " + Thread.currentThread().getName() + " termino su suma parcial.");   
    }

    public static void mostrarResFinal()
    {
        System.out.println(resultadoFinal.getRes());
    }
}
