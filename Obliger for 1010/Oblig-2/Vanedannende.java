public class Vanedannende extends Legemiddel{

    // En protected variabel for styrke
    protected int styrke;

    public Vanedannende(String Navnet, int Prisen, double mg, int styrke) {
        super(Navnet, Prisen, mg);
        this.styrke = styrke;
    }

    // Henter styrken til vanedannende legemiddel
    public int hentVanedannendeStyrke() {
        return styrke;
    }

    // Oversikt over legemiddelet
    @Override
    public String toString() {
        String helStreng = "Hele oversikten over Vanedannende-legemiddel: ";
        helStreng += super.toString();
        helStreng += "Styrke: " + styrke;
        return helStreng;
    }


}
