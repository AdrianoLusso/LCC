public class Act6CajeroThread extends Thread
{
    private String nombre;
    private Act6Cliente cliente;
    private long initialTime;

    public Act6CajeroThread(String nombre,Act6Cliente cliente,long initialTime)
    {
        this.nombre = nombre;
        this.cliente = cliente;
        this.initialTime = initialTime;
    }

    public Act6Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Act6Cliente cliente) {
        this.cliente = cliente;
    }

    public long getInitialTime() {
        return this.initialTime;
    }

    public void setInitialTime(long initialTime) {
        this.initialTime = initialTime;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void run()
    {
        System.out.println("El cajero " +this.nombre+ " COMIENZA "+
         " A PROCESAR LA COMPRA DEL CLIENTE " +this.cliente.getNombre()+ 
         " EN EL TIEMPO: " +(System.currentTimeMillis() - this.initialTime) / 1000
         + "seg");

         for(int i = 0;i < cliente.getCarroCompra().length; i++)
         {       
            this.esperarXsegundos(cliente.getCarroCompra()[i]);    
             System.out.println("Procesando el producto " +(i + 1)+ 
             " del cliente " +this.cliente.getNombre()+  "->Tiempo: "
              +(System.currentTimeMillis() - this.initialTime) / 1000 + "seg");           
         }

         System.out.println("El cajero" +this.nombre+ "HA TERMINADO DE "
         +"PROCESAR" +this.cliente.getNombre()+ "EN EL TIEMPO: "+
          (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
    }

    private void esperarXsegundos(int tiempo)
    {
        try {
            Thread.sleep(tiempo * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}