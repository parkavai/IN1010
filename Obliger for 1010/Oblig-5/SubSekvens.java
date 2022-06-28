public class SubSekvens {

    private String subSekvens;

    private int antallSubSekvens = 1;

    public SubSekvens(String subSekvens) {
        this.subSekvens = subSekvens;
    }

    public int hentAntallForekomster() {
        return antallSubSekvens;
    }

    public void oekAntallForekomster(int oektAntall) {
        this.antallSubSekvens += oektAntall;
    }

    public String hentNoekkel() {
        return subSekvens;
    }    
}