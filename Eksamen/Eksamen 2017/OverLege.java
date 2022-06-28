public class OverLege extends Lege{

    final String spesialiseringsType;

    OverLege(String ansattId, String navn, int legenummer, String spesialiseringsType){
        super(ansattId, navn, legenummer);
        this.spesialiseringsType = spesialiseringsType;
    }

    
}
