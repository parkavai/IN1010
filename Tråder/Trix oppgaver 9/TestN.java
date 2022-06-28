public class TestN {

    public static void main(String[] args) {
        /*
        Oppgave 1.)
        Runnable n1 = new N(); 
        Thread t1 = new Thread(n1);
        t1.start();
        */

        Runnable n2 = new N(1,10,20); 
        Thread t2 = new Thread(n2);
        t2.start();

        for(int i = 0; i<10; i++){
            new Thread(new N(i, 0, 1000)).start();
        }

    }
    
}
