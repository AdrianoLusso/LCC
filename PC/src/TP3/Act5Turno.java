public class Act5Turno {
    
    private int num;

    public Act5Turno()
    {
        num = 1;
    }


    public synchronized int getNum() {
        return this.num;
    }

    public synchronized void sigNum() {
        //num = (num + 1) % 3;

        if(num == 3)
        {
            num = 1;
        }
        else
        {
            num++;
        }
    };

}
