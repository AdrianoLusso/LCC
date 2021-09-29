public class Act5Main {
    
    public static void main(String[] args)
    {
        Thread[] arr = new Thread[10];
        
        for(int i = 0;i<6;i++)
        {
            arr[i] = new Thread(new Act5Usuario('A'),""+i);
        }
        
        for(int i = 6;i<10;i++)
        {
            arr[i] = new Thread(new Act5Usuario('B'),""+i);
        }
        
        for(int i = 0;i<10;i++)
        {
            arr[i].start();
            
        }
    }

    /*
    Fallo:
 1 genera su trabajo.
9 genera su trabajo.
8 genera su trabajo.
7 genera su trabajo.
6 genera su trabajo.
5 genera su trabajo.
3 genera su trabajo.
4 genera su trabajo.
0 genera su trabajo.
2 genera su trabajo.
1 c: 3
8 c: 2
1 esta imprimiendo en imp A
9 c: 1
8 esta imprimiendo en imp B
6 c: 0
9 esta imprimiendo en imp B
7 c: 0
5 c: 2
5 esta imprimiendo en imp A
4 c: 1
3 c: 1!!!ACA ESTA EL ERROR
0 c: 1
2 c: 1
4 esta imprimiendo en imp A
1 termino
3 esta imprimiendo en imp A
8 termino
6 esta imprimiendo en imp B
9 termino
7 esta imprimiendo en imp B
5 termino
0 esta imprimiendo en imp A
4 termino
2 esta imprimiendo en imp A
3 termino
7 termino
6 termino
0 termino
2 termino
    */
}
