public class Act6Cajero
{
    private String nombre;

    public Act6Cajero(String nombre)
    {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void procesarCompra(Act6Cliente cliente,long timeStamp)
    {
        System.out.println("El cajero " +this.nombre+ " COMIENZA "+
         " A PROCESAR LA COMPRA DEL CLIENTE " +cliente.getNombre()+ 
         " EN EL TIEMPO: " +(System.currentTimeMillis() - timeStamp) / 1000
         + "seg");

         for(int i = 0;i < cliente.getCarroCompra().length; i++)
         {       
            this.esperarXsegundos(cliente.getCarroCompra()[i]);    
             System.out.println("Procesando el producto " +(i + 1)+ 
             "->Tiempo: " +(System.currentTimeMillis() - timeStamp) /
             1000 + "seg");           
         }

         System.out.println("El cajero" +this.nombre+ "HA TERMINADO DE "
         +"PROCESAR" +cliente.getNombre()+ "EN EL TIEMPO: "+
          (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
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