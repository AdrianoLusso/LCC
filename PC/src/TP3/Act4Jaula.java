public class Act4Jaula {
    
    public static void main (String[] args)
    {
        Thread pepe = new Thread(new Act4Hamster(),"Pepe");
        Thread lucas = new Thread(new Act4Hamster(),"Lucas");
        Thread juan = new Thread(new Act4Hamster(),"Juan");

        pepe.start();
        lucas.start();
        juan.start();

        try {
            juan.join();
            pepe.join();
            lucas.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Todos los hamsters terminaron");
    }

}
