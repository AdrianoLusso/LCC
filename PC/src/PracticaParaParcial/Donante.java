public class Donante implements Runnable {
    
    private static Hospital hospital;
    private int turno;

    public Donante(Hospital hosp)
    {
        hospital = hosp;
    }

    public void run()
    {
        //LLama al centro para ofrecerse de donante
        //Espera a que el recepcionista los registre,y termina el llamado
        hospital.llamar();

        //Asiste al centro, y recibe un nro para atenderse.
        System.out.println(Thread.currentThread().getName() + " va al centro");
        turno = hospital.irAlCentro();

        //Espera su turno de control
        System.out.println(Thread.currentThread().getName() + " espera que lo llamen,turno: " + turno);
        hospital.esperarControl(turno);

        //Cuando es su turno, el especialista clinico le hace el control.
        hospital.controlClinico();

        //Espera su turno de extraccion
        hospital.esperarExtraccion(turno);

        //Cuando es su turno,el especialista de extraccion lo atiende
        hospital.extraccion();

        //Va a desayunar
        this.desayunar();

        //Muere el hilo

    }

    public void desayunar()
    {
        System.out.println(Thread.currentThread().getName() + " desayuna.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " termina de desayunar");
    }
    
}
