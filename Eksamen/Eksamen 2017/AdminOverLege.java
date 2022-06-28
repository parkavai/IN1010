public class AdminOverLege implements Adminstrator{

    String ansvarsKode;

    AdminOverLege(String ansattId, String navn, int legenummer, String spesialiseringsType, String ansvarsKode){
        this.ansvarsKode = ansvarsKode;
        System.out.println("AnsvarsKode for overlege er følgende: " + ansvarsKode);
    }

    @Override
    public String hentAnsvarsKode(){
        return ansvarsKode;
    }
    
}
