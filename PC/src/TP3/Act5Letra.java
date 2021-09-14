
public class Act5Letra implements Runnable {
    
    private static Act5Turno gestorTurno = new Act5Turno();
    private static int cantidadItr = 3;
    private int turno;
    private char letra;

    public Act5Letra(char letra,int turno){
        this.letra = letra;
        this.turno = turno;
    }

    public void run(){

        do{
            if (gestorTurno.getNum() == turno)
            {
                for(int i = 0;i < turno;i++)
                {
                    System.out.print(letra);
                }
            
                if(letra == 'C')
                {
                    cantidadItr--;
                }

                gestorTurno.sigNum();
            }else 
            {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }while(cantidadItr > 0);
        
    }

}
