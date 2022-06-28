public class Sil implements Runnable{

    PasientPrio pasientPrio;
    AnalyseBuffer analyseBuffer;
    int prio;

    Sil(PasientPrio pasientPrio, AnalyseBuffer analyseBuffer, int prio){
        this.pasientPrio = pasientPrio;
        this.analyseBuffer = analyseBuffer;
        this.prio = prio;
    }

    @Override
    public void run(){
        while(pasientPrio.hentUt(prio) != null){
            if(pasientPrio.hentUt(prio) == null){
                break;
            }
            else {
                Pasient pasient = pasientPrio.hentUt(prio);
                try{
                    if(pasient.iFaresonen() == true){
                        analyseBuffer.leggTil(pasient);
                    }
                }
                catch(InterruptedException e){
                    System.out.println("Skjedde feil ved å legge inn");
                }
            }
        }

    }



    
}
