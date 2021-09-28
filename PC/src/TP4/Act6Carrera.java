public class Act6Carrera {
    
    public static void main(String[] args)
    {
        Thread pepe = new Thread(new Act6Atleta(1),"Pepe");
        Thread juan = new Thread(new Act6Atleta(1),"Juan");
        Thread lucas = new Thread(new Act6Atleta(2),"Lucas");
        Thread tom = new Thread(new Act6Atleta(2),"Tom");

        pepe.start();
        juan.start();
        lucas.start();
        tom.start();
    }
}
