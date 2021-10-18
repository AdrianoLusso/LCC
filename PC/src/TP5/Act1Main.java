public class Act1Main {
    
    public static void main(String[] args)
    {
        Thread[] arr = new Thread[30];
        
        //perros
        for(int i = 0;i<20;i++)
        {
            arr[i] = new Thread(new Act1Animal(false),"gato-"+i);
        }

        //gatos
        for(int i = 20;i<30;i++)
        {
            arr[i] = new Thread(new Act1Animal(true),"perro-"+i);
        }

        for(int i = 0;i<30;i++)
        {
            arr[i].start();
        }
        
    }
}
