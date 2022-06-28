
public class BlaaResept extends Resept{

    protected double rabatt = 0.25;

    BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege,  int pasientId ,int reit  ){
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }

    // Fargen til resepten
    @Override
    public String farge(){
        String fargen = "Blå";
        return fargen;

    }

    // Prisen til blå-resept
    @Override
    public int prisAaBetale(){
        int nyPris = legemiddel.hentPris();
        nyPris = (int) Math.round(nyPris*rabatt);
        return nyPris;
    }

    // Oversikten for blå-resept
    @Override
    public String toString() {
        String helStreng = "Hele oversikten over Blå-resept: \n";
        helStreng += "Farge: " + this.farge();
        helStreng += super.toString();
        helStreng += "Prisen: " + this.prisAaBetale() + "\n";
        return helStreng;
    }
   
}