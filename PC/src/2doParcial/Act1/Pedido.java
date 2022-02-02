package parcial2.Act1;

public class Pedido {
    
    String cliente;
    boolean tipo;

    //1:orden de pedido entregada 2:en proceso de cocina 3: para ser retirado del mostrador.
    int estado;

    public Pedido(String c,boolean t)
    {
        cliente = c;
        tipo = t;
        estado = 1;
    }

    public String getCliente()
    {
        return cliente;
    }

    public int getEstado()
    {
        return estado;
    }

    public boolean getTipo()
    {
        return tipo;
    }

    public void aumentarEstado()
    {
        estado++;
    }
}
