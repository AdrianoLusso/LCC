
public class Act3ThreadEjemplo extends Thread{
   
    public Act3ThreadEjemplo(String str){
        super(str);
    }

    public void run(){
        for(int i = 0;i < 10 ; i++)
        {
            System.out.println(i + " " + getName());
        }
            System.out.println("Termina thread " + getName());
    }

    public static void main (String[] args)
    {
        new Act3ThreadEjemplo("Maria Jose").start();
        new Act3ThreadEjemplo("Jose Maria").start();
        System.out.println("Termina thread main");
    }

    /*
    Se van alternando,en cuanto a que sucede primero,lo siguiente:

    Las iteraciones
    Las string de termina thread nombres.

    El string termina thread main,siempre se mantiene al principio del todo.
    */
}