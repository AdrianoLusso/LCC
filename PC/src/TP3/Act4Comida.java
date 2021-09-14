public class Act4Comida {

    public synchronized static void comer()
    {
        System.out.println("El hamster " +Thread.currentThread().getName()+
        " empezo a comer");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("El hamster " +Thread.currentThread().getName()+
        " termino de comer");
    }

}
