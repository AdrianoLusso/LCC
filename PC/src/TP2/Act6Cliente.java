package TP2;


public class Act6Cliente
{
    private String nombre;
    private int[] carroCompra;

    public Act6Cliente(String nombre,int[]carro)
    {
        this.nombre = nombre;
        this.carroCompra = carro;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int[] getCarroCompra() {
        return this.carroCompra;
    }

    public void setCarroCompra(int[] carroCompra) {
        this.carroCompra = carroCompra;
    }
}