public class Act4Hamster implements Runnable {

    public Act4Hamster(){

    }

    @Override
    public void run() {
        Act4Comida.comer();
        Act4Rueda.rodar();
        Act4Hamaca.dormir();
    }

}
