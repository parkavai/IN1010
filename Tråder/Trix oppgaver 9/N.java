class N implements Runnable{
    
    int n = 0;
    int start = 0;
    int maks = 0;

    public N(int n,int start,int maks){
        this.n = n;
        this.start = start;
        this.maks = maks;
    }

    public void run(){
        for(int i = n; start < maks; i += 10){
            start++;
            System.out.println(i);

        }
    }

    /*
    Oppgave 1.)
    public void run(){
        
        for(int i = 5; i < 1000; i += 10){

            System.out.println(i);

        }
    }
    */

}