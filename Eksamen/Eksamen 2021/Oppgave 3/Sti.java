// Oppgave 1 c.)

abstract class Sti implements Godutsikt{
    private int lengde;
    private Kryss ende1;
    private Kryss ende2;
    private int utsiktsVerdi;

    Sti(Kryss ende1, Kryss ende2, int utsiktsVerdi){
        this.ende1 = ende1;
        this.ende2 = ende2;
        lengde = Trekk.trekkInt(220, 2500);
        this.utsiktsVerdi = utsiktsVerdi;
        if(utsiktsVerdi < 1 || utsiktsVerdi > 6){
            throw new UtenforUtsiktsVerdi(utsiktsVerdi);
        }
    }

    public Kryss finnAndreEnde(){
        return ende2;
    }

    // Usikker paa hvordan jeg skulle finne tiden
    public int beregnGaaTid(int fart){
        int tid = lengde*fart;
        return tid;
    }

    @Override
    public boolean harGodUtsikt(){
        return true;
    }
    
}
