public class Carpintero implements Runnable {
    
    /*
    clasificacion de tipos:
    0: ensamblador
    1,2,3: fabrica su respectiva parte 1,2,3. 
    */
    private int tipo;
    private Buffer buffer;


    public Carpintero(int tipo,Buffer buffer)
    {
        this.tipo = tipo;
        this.buffer = buffer;
    }

    public void run()
    {
        switch(tipo)
        {
            case 0:
                this.ensamblador();
                break;
            case 1:
                this.parte1();
                break;
            case 2:
                this.parte2();
                break;
            case 3:
                this.parte3();
                break;
        }
    }

    private void ensamblador()
    {
        while(buffer.ensamblarPartes())
        {
            //Toma parte 1
            buffer.tomarParte1();

            //Toma parte 2
            buffer.tomarParte2();

            //Toma parte 3
            buffer.tomarParte3();

            //Ensambla
            System.out.println(Thread.currentThread().getName() + " empieza a ensamblar las partes.");
            try {
                Thread.sleep(1300);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " termino de ensamblar las partes.");

            //Notificar el fin del ensamble.
            buffer.finalizarEnsamble();
        }
    }

    private void parte1()
    {
        //Verificar si queda parte por armar.
        while(buffer.armarParte1())
        {
        //Si queda parte por armar, la arma.
        System.out.println(Thread.currentThread().getName() + " empieza a armar parte 1.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " termina de armar parte 1.");

        //entrega la pieza, y espera a que esa pieza sea ensamblada.
        buffer.entregarParte1();
        }
    }

    private void parte2()
    {
        //Verificar si queda parte por armar.
        while(buffer.armarParte2())
        {
        //Si queda parte por armar, la arma.
        System.out.println(Thread.currentThread().getName() + " empieza a armar parte 2.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " termina de armar parte 2.");

        //entrega la pieza, y espera a que esa pieza sea ensamblada.
        buffer.entregarParte2();
        }
    }

    private void parte3()
    {
        //Verificar si queda parte por armar.
        while(buffer.armarParte3())
        {
        //Si queda parte por armar, la arma.
        System.out.println(Thread.currentThread().getName() + " empieza a armar parte 3.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " termina de armar parte 3.");

        //entrega la pieza, y espera a que esa pieza sea ensamblada.
        buffer.entregarParte3();
        }
    }
}
