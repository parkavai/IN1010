class TelefonBok {

    String navn = null;
    String tlfnr = null;

    public TelefonBok(String navn, String tlfnr) {
        this.navn = navn;
        this.tlfnr = tlfnr;
    }

    public String hentNavn(){
        return navn;
    }

    public String hentTlf(){
        return tlfnr;
    }

    public String toString() {
        return this.navn + this.tlfnr + "\n";
    }

}