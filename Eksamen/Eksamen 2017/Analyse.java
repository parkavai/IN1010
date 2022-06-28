public class Analyse implements Runnable{

    PasientPrio pasientPrio;
    AnalyseBuffer analyseBuffer;

    Analyse(PasientPrio pasientPrio, AnalyseBuffer analyseBuffer){
        this.pasientPrio = pasientPrio;
        this.analyseBuffer = analyseBuffer;
    }


    @Override 
    public void run(){
        try {
            Pasient p = analyseBuffer.hentUt();
            p.kanHaSykdom();
        }
        catch(InterruptedException e){
            System.out.println("Skjedde feil ved henting");
        }
    }
}
