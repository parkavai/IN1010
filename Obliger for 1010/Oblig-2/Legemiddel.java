public abstract class Legemiddel{

    // En static variabel "teller" som øker for hver gang vi initialiserer et nytt objekt.
    private static int teller = -1;

    /* En variabel "id" som får verdien fra den statiske variabelen for å unngå
    at alle objektene for samme "id". */
    
    private int id = 0;

    // Navnet til legemiddelet som er tilgjengelig for alle subklasser.
    protected String navn;

    // Prisen til legemiddelet som er tilgjengelig for alle subklasser.
    protected int pris;

    // Virkestoffet til legemiddelet som er tilgjengelig for alle subklasser.
    protected double virkestoff;


    public Legemiddel(String navn, int pris, double virkestoff){
        teller ++;
        this.navn = navn;
        this.pris = pris;
        this.virkestoff = virkestoff;
        id = teller;
    }

    // Henter id til legemiddelet.
    public int hentId(){
        return id;
    }

    // Henter navnet til legemiddelet.
    public String hentNavn(){
        return navn;
    }

    // Henter prisen til legemiddelet.
    public int hentPris() {
        return pris;
    }

    // Endrer på prisen til legemiddelet.
    public void settNyPris(int nyPris) {
        pris = nyPris;
    }

    // Henter virkestoffet til legemiddelet.
    public double hentVirkestoff() {
        return virkestoff;
    }

    // Oversikt over legemiddelet
    public String toString() {
        String helStreng = " \n";
        helStreng += "Legemiddel-Id: " + id + "\n";
        helStreng += "Legemiddel-navn: " + navn + "\n";
        helStreng += "Prisen: " + pris + "\n";
        helStreng += "Virkestoff: " + virkestoff + "\n";
        return helStreng;
    }


}
