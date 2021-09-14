public class Act4Hamaca {
    
    public synchronized static void dormir()
    {
        System.out.println("El hamster " +Thread.currentThread().getName()+
        " empezo a dormir");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("El hamster " +Thread.currentThread().getName()+
        " termino de dormir");
    }
    
}
