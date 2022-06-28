public class HvitResept extends Resept{

    HvitResept(Legemiddel legemiddel, Lege utskrivendeLege,  int pasientId ,int reit  ){
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
        return legemiddel.hentPris();
    }

    // Oversikt over hvit-resept
    @Override
    public String toString() {
        String helStreng = "Hele oversikten over Hvit-resept: \n";
        helStreng += "Farge: " + this.farge();
        helStreng += super.toString();
        helStreng += "Prisen: " + this.prisAaBetale() + "\n";
        return helStreng;
    }


}
