

public class Act1CuentaBanco {

    private int balance = 50;

    public Act1CuentaBanco(){
    }
    public int getBalance(){
    return balance;
    }
    public void retiroBancario(int retiro){
    balance = balance - retiro;
    }
    }