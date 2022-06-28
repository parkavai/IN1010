public class Vanlig extends Legemiddel{

    public Vanlig(String Navnet, int Prisen, double mg){
        super(Navnet, Prisen, mg);
    }   

    // Oversikt over legemiddelet
    @Override
    public String toString() {
        String helStreng = "Hele oversikten over Vanlig-legemiddel: ";
        helStreng += super.toString();
        return helStreng;
    }

}
