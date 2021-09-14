public class Act4Rueda {
    

    public synchronized static void rodar()
    {
        System.out.println("El hamster " +Thread.currentThread().getName()+
        " empezo a rodar");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("El hamster " +Thread.currentThread().getName()+
        " termino de rodar");
    }
}
