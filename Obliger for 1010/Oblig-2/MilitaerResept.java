public class MilitaerResept extends HvitResept{

    MilitaerResept(Legemiddel legemiddel, Lege utskrivendeLege,  int pasientId ,int reit  ){
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }

    // Fargen på resepten  
    @Override
    public String farge(){
        String fargen = "Hvit";
        return fargen;

    }

    // Prisen for militær-resept
    @Override
    public int prisAaBetale(){
        int nyPris = legemiddel.hentPris();
        nyPris = 0;
        return nyPris;
    }

    // Oversikt over militær-resept
    @Override
    public String toString() {
        String helStreng = "Hele oversikten over Militær-resept: \n";
        helStreng = super.toString();
        return helStreng;
    }

}
