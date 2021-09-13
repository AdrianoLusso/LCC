public class Act1Recurso{

    static void uso(){
        Thread t = Thread.currentThread();
        System.out.println("en Recurso: Soy " + t.getName());

    }
}