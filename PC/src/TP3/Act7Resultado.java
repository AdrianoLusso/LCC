public class Act7Resultado {
    
    private int resultado = 0;

    public Act7Resultado()
    {

    }

    public synchronized void sumar(int num)
    {
        resultado += num;
    }

    public int getRes()
    {
        return resultado;
    }
}
