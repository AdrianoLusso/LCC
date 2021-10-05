public class Act9Main {
    
    public static void main(String[] args)
    {
        int n = 5;
        Thread[] arr = new Thread[n]; 

        for(int i = 0;i<n;i++)
        {
            arr[i] = new Thread(new Act9Hamster(),""+i);
        }

        for(int i = 0;i <n;i++)
        {
            arr[i].start();
        }
    }
}
