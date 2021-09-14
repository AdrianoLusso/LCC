

public class Act1Main {
public static synchronized void main(String[] args) {
Act1VerificarCuenta vc = new Act1VerificarCuenta();
Thread Luis = new Thread(vc, "Luis");
Thread Manuel = new Thread(vc, "Manuel");
Luis.start();
Manuel.start();
}
}

/*
Lo que sucede es que la cuenta no va actualizandose correctamente
luego de hacer los retiros,y termina sobregirada.
Para evitar esa situacion,y proteger el dato compartido balance,
es necesario hacer synchronized el metodo hacerRetiro() de la clase
verificarCuenta.Es necesario hacerlo aca,y no en el retiroBancario()
de CuentaBanco, ya que en hacerRetiro() se encuentra un control importante
cb.getBalance() >= cantidad,que en caso de no cumplirse,puede generar
que la cuenta este sobregirada.Es importante ver que ese control puede
fallar porque opera directamente con el valor compartido balance.
*/
