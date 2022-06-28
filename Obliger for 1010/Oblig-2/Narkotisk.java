public class Narkotisk extends Legemiddel{

    // En protected variabel for styrke
    protected int styrke;

    public Narkotisk(String Navnet, int Prisen, double mg, int styrke){
        super(Navnet, Prisen, mg);
        this.styrke = styrke;
    }

    // Henter styrken til narkotisk legemiddel
    public int hentNarkotiskStyrke() {
        return styrke;
    }

    // Oversikt over legemiddelet
    @Override
    public String toString() {
        String helStreng = "Hele oversikten over Narkotisk-legemiddel: ";
        helStreng += super.toString();
        helStreng += "Styrke: " + styrke;
        return helStreng;
    }



}
