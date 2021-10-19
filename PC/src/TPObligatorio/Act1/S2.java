package Act1;

public class S2 implements Runnable{
    
    //Runnable que realiza el proceso S2.
    
    private int z;
    private S3S4 fin;

    public S2(int z,S3S4 fin)
    {
        this.z = z;
        this.fin = fin;
    }

    public void run()
    {
        fin.S2Listo(z-1);
    }
}
