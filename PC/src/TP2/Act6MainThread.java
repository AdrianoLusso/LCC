package TP2;

public class Act6MainThread {
    
    public static void main(String[] args)
    {
        Act6Cliente cliente1 = new Act6Cliente("Cliente 1",new int[]{2,2,1,5,2,3});
        Act6Cliente cliente2 = new Act6Cliente("Cliente 2",new int[]{1,3,5,1,1});
        long initialTime = System.currentTimeMillis();
        Act6CajeroThread cajero1 = new Act6CajeroThread("Cliente 1",cliente1,initialTime);
        Act6CajeroThread cajero2 = new Act6CajeroThread("Cliente 2",cliente2,initialTime);
        
        cajero1.start();
        cajero2.start();
    }
}
