public class Spesialister extends Lege implements Godkjenningsfritak {
    
    // Kontroll-id til spesialisten
    protected String kontrollID;

    public Spesialister(String navn, String kontrollID) {
        super(navn);
        this.kontrollID = kontrollID;
    }

    // Henter kontroll-iden til spesialisten
    public String hentKontrollID(){
        return kontrollID;
    }

    // Oversikt over spesialist
    @Override
    public String toString() {
        String helString = "spesialist: " + super.hentNavn() + "\n";
        helString += "Kontroll-id: " + kontrollID;
        return helString;
    }

}
