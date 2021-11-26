package Act6;

public class Act6Carrera {
    
    public static void main(String[] args)
    {
        Thread[] arr = new Thread[6];
        //Thread nina = new Thread(new Act6Atleta(1),"Layla");

        for(int i = 0;i<3;i++)
        {
            arr[i] = new Thread(new Act6Atleta(0),""+i);
        }

        for(int i = 3;i<6;i++)
        {
            arr[i] = new Thread(new Act6Atleta(1),""+i);
        }

        for(int i = 0;i<6;i++)
        {
            arr[i].start();
            
        }
    }
}
