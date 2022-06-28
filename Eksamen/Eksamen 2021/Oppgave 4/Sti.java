// Oppgave 4

abstract class Sti implements Godutsikt{
    private int lengde;
    // Maa gjore disse om til public for aa faa tilgang til kryssene for en sti
    Kryss kryss1;
    Kryss kryss2;
    private int utsiktsVerdi;

    Sti(Kryss kryss1, Kryss kryss2, int utsiktsVerdi){
        this.kryss1 = kryss1;
        this.kryss2 = kryss2;
        lengde = Trekk.trekkInt(220, 2500);
        this.utsiktsVerdi = utsiktsVerdi;
        if(utsiktsVerdi < 1 || utsiktsVerdi > 6){
            throw new UtenforUtsiktsVerdi(utsiktsVerdi);
        }
    }

    public Kryss finnAndreEnde(){
        return kryss2;
    }

    // Usikker på hvordan jeg skulle løse dette
    public int beregnGaaTid(int fart){
        int tid = lengde*fart;
        return tid;
    }

    @Override
    public boolean harGodUtsikt(){
        return true;
    }
    
}