// Oppgave 3

public class Turgaaer implements Runnable{
    private int hastighet;
    private Kryss sted;
    private int tiden = 0;
    Turgaaer(int hastighet, Kryss sted){
        super();
        this.sted = sted;
    }

    @Override
    public void run(){
        while(true){
            try{
                sted.turgaaerKommer();
                // Antar at det er minutter 
                Thread.sleep(Trekk.trekkInt(1, 5) * 10000000);
                sted.turgaaerKommer();
                if(hastighet == 20){
                    Thread.sleep(20*1000);
                }
                else {
                    Thread.sleep(hastighet);
                }
                if(hastighet == 120){
                    break;
                }
            }
            catch(InterruptedException e){
                System.out.println("Skjedde feil");
            }
        }   

    }

    
}
