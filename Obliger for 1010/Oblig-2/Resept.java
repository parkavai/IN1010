public abstract class Resept{

    // En static variabel "teller" som øker for hver gang vi initialiserer et nytt objekt.
    private static int teller = -1;

    /* En variabel "id" som får verdien fra den statiske variabelen for å unngå
    at alle objektene for samme "id". */
    private int id = 0;

    // Referanse til legemiddel.
    protected Legemiddel legemiddel;

    // Referanse til lege.
    protected Lege utskrivendeLege;

    // Id til pasienten.
    protected int pasientId;

    // Antall reit for resepten.
    protected int reit;

    Resept(Legemiddel legemiddel, Lege utskrivendeLege,  int pasientId ,int reit ){
        teller ++;
        id = teller;
        this.legemiddel = legemiddel;
        this.utskrivendeLege = utskrivendeLege;
        this.pasientId = pasientId;
        this.reit = reit;
    }

    // Henter id til legemiddelet.
    public int hentId(){
        return id;
    }

    // Henter objektet til legemiddelet.
    public Legemiddel hentLegemiddel(){
        return legemiddel;
    }

    // Henter objektet til legen.
    public Lege hentLege() {
        return utskrivendeLege;
    }

    // Henter id til pasienten.
    public int hentPasientId() {
        return pasientId;
    }

    // Henter antall reit.
    public int hentReit() {
        return reit;
    }

    /* Senker reit for hver gang metoden kalles. Sjekker om den resepten er gyldig
    eller ikke og returnerer ønsket boolean. */

    public boolean bruk() {
        reit--;
        boolean gyldig;
        if (reit > 0) {
            gyldig = true;
        }
        else {
            gyldig = false;
            System.out.println("Reseptet er ugyldig");
        }
        return gyldig;
    }

    // Oversikt over resept
    public String toString() {
        if (legemiddel instanceof Narkotisk){
            if (!(utskrivendeLege instanceof Spesialister)) {
                return "Beklager, men det er kun leger med godkjenningsfritak som kan skrive ut narkotiske legemidler";
            }
        }
        String helStreng = " \n";
        helStreng += "Resept-Id: " + id + "\n";
        helStreng += "Legemiddel-navn: " + legemiddel.hentNavn() + "\n";
        helStreng += "Utskrevet av : " + utskrivendeLege.toString() + "\n";
        helStreng += "Pasient-id: " + pasientId + "\n";
        return helStreng;
    }

    public abstract String farge();

    public abstract int prisAaBetale();


}
