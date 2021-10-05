public class Act7Main {
    
    public static void main (String[] args)
    {

        Act7Taxi taxi = new Act7Taxi();
        Thread taxista = new Thread(new Act7Taxista(taxi),"taxista");
        Thread[] arr = new Thread[5];
        
        for(int i = 0;i < 5;i++)
        {
            arr[i] = new Thread(new Act7Pasajero(taxi), i+1+"");
        }

        taxista.start();
        for(int i = 0;i < 5;i++)
        {
            arr[i].start();
        }
    }
}
