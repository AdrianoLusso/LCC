package TP2;

public class Act6Main {
    
    public static void main(String[] args)
    {
        Act6Cliente cliente1 = new Act6Cliente("Cliente 1",new int[]{2,2,1,5,2,3});
        Act6Cliente cliente2 = new Act6Cliente("Cliente 2",new int[]{1,3,5,1,1});
        Act6Cajero cajero1 = new Act6Cajero("Cajero 1");

        long initialTime = System.currentTimeMillis();
        cajero1.procesarCompra(cliente1, initialTime);
        cajero1.procesarCompra(cliente2, initialTime);
        
    }
}
