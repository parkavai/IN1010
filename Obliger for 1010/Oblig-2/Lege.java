public class Lege{

    // Navnet til legen.
    protected String navn;

    public Lege(String navn){
        this.navn = navn;
    }

    // Henter navnet til legen.
    public String hentNavn(){
        return navn;
    }

    // Oversikt over legen
    @Override
    public String toString() {
        String helString = "lege: " + navn;
        return helString;
    }


}