public class Presept extends HvitResept{

    protected static int reit = 3;

    protected static int rabatt = 108;

    Presept(Legemiddel legemiddel, Lege utskrivendeLege,  int pasientId){
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }

    // Fargen på resepten 
    @Override
    public String farge(){
        String fargen = "Hvit";
        return fargen;

    }

    // Prisen for p-resept
    @Override
    public int prisAaBetale(){
        int opprinneligPris = legemiddel.hentPris();
        int nyPris = 0;
        if (opprinneligPris > rabatt) {
            nyPris = (opprinneligPris - rabatt);
        }
        else {
            nyPris = 0;
        }
        
        return nyPris;
    }

    // Oversikt over p-resept
    @Override
    public String toString() {
        String helStreng = "Hele oversikten over P-resept: \n";
        helStreng = super.toString();
        return helStreng;
    }

}
