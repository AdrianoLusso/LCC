package Act5;
public class Act5Main {
    
    public static void main(String[] args)
    {
        Thread[] arr = new Thread[20];
        
        for(int i = 0;i<10;i++)
        {
            arr[i] = new Thread(new Act5Usuario('A'),""+i);
        }
        
        for(int i = 10;i<20;i++)
        {
            arr[i] = new Thread(new Act5Usuario('B'),""+i);
        }
        
        for(int i = 0;i<20;i++)
        {
            arr[i].start();
        }
    }
}
