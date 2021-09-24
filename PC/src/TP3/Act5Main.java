public class Act5Main {
    
    public static void main(String[] args)
    {
        Thread a = new Thread(new Act5Letra('A',1,1,false), "A");
        Thread b = new Thread(new Act5Letra('B',2,2,false), "B");
        Thread c = new Thread(new Act5Letra('C',3,3,true), "C");
        
        b.start();
        a.start();
        c.start();
    }
}
