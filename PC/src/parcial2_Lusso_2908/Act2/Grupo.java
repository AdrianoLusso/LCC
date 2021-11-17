package parcial2_Lusso_2908.Act2;

public class Grupo implements Runnable {
    
    //1 o 2
    int cant;
    /*
    1: era miembro de una pareja, y el sistema le asigno fila 1
    2: era miembro de una pareja, y el sistema le asigno fila 2
    3: fue solo a bailar, en el momento elegeria que fila.
    */
    int fila;
    PistaBaile pista = new PistaBaile();

    public Grupo(PistaBaile pista,int cant,int fila)
    {
        this.pista = pista;
        this.cant = cant;
        this.fila = fila;
    }

    public void run()
    {
        if(cant == 2)
        {
            dividirPareja();
        }

        //Unirse a fila y esperar
        pista.irAFila(fila);

        //Es su turno,y se uno a bailar con su pareja.
        pista.vaABailar();

        //se retira
    }

    public void dividirPareja()
    {
        Thread a = new Thread(new Grupo(pista,1,1),Thread.currentThread().getName() + ".a");
        Thread b = new Thread(new Grupo(pista,1,2),Thread.currentThread().getName() + ".b");
        a.start();
        b.start();

    }
}
