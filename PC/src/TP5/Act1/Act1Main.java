package Act1;

public class Act1Main {
    
    public static void main(String[] args)
    {
        Thread[] arr = new Thread[15];
        
        //perros
        for(int i = 0;i<7;i++)
        {
            arr[i] = new Thread(new Act1Animal(false),"gato-"+i);
        }

        //gatos
        for(int i = 7;i<15;i++)
        {
            arr[i] = new Thread(new Act1Animal(true),"perro-"+i);
        }

        for(int i = 0;i<15;i++)
        {
            arr[i].start();
        }
        
    }
}
