abstract class Pasient {

    private int prioritet;
    private Pasient neste;
    private String navn; 
    static int teller;
    int sengNr;

    Pasient(String navn, int prio){
        this.prioritet = prio;
        neste = null;
        teller ++;
        this.navn = navn;
    }

    abstract void kanHaSykdom();
    abstract boolean iFaresonen();

    public int hentPrio(){
        return prioritet;
    }

    public void settSengeNr(int sengNr){
        this.sengNr = sengNr;
    }

    public Pasient hentNeste(){
        return this.neste;
    }

    public void settNeste(Pasient p){
        this.neste = p;
    }
    
}
