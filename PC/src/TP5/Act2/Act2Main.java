package Act2;

public class Act2Main {
    
    public static void main(String[] args)
    {
        Thread[] arr = new Thread[20];
        
        //perros
        for(int i = 0;i<11;i++)
        {
            arr[i] = new Thread(new Act2Animal(false),"gato-"+i);
        }

        //gatos
        for(int i = 11;i<20;i++)
        {
            arr[i] = new Thread(new Act2Animal(true),"perro-"+i);
        }

        for(int i = 0;i<20;i++)
        {
            arr[i].start();
        }
        
    }
}
