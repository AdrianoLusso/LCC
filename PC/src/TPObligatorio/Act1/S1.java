package Act1;

public class S1 implements Runnable {
    
    //Runnable que realiza el proceso S1.

    private int x,y;
    private S3S4 fin;

    public S1(int x,int y,S3S4 fin)
    {
        this.x = x;
        this.y = y;
        this.fin = fin;

    }

    public void run()
    {
        fin.S1Listo(x+y);
    }
}
