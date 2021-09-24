
public class Act5Letra implements Runnable {
    
    private static Act5Turno gestorTurno = new Act5Turno();
    private static int cantidadItr = 3;
    private int turno;
    private int cant;
    private char letra;
    private boolean ultimoChar;

    public Act5Letra(char letra,int cant,int turno,boolean ult){
        this.letra = letra;
        this.turno = turno;
        this.cant = cant;
        this.ultimoChar = ult;
    }

    public void run(){

        do{
            if (gestorTurno.getNum() == turno)
            {
                for(int i = 0;i < cant;i++)
                {
                    System.out.print(letra);
                }
    
                if(ultimoChar)
                {
                    System.out.println("-itr " + cantidadItr);
                    cantidadItr--;
                }
                
                gestorTurno.sigNum();
            }else 
            {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }while(cantidadItr > 0);
        
    }

}
