public class Lege extends Ansatte{

    final int legeNummer;

    Lege(String ansattId, String navn,int legeNummer){
        super(ansattId, navn);
        this.legeNummer = legeNummer;
    }
}
