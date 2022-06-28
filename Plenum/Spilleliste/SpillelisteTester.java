import java.util.ArrayList;
public class SpillelisteTester {
    public static void main(String[] args) {
        Spilleliste allMusikk = new Spilleliste("Hele musikkbiblioteket");
        allMusikk.lesFraFil("Musikk.txt");

        System.out.println("Tester spillAlle: Spiller alle sanger i listen:");
        allMusikk.spillAlle();
        System.out.println();

        Sang nySang = new Sang("Mil etter mil", new String[]{"Jahn Teigen"});
        System.out.println("Spiller ny sang:");
        allMusikk.spillSang(nySang);
        System.out.println();

        allMusikk.leggTilSang(nySang);
        System.out.println("Spiller alle sanger i listen inkl ny sang:");
        allMusikk.spillAlle();
        System.out.println();

        ArrayList<Sang> queenListe = allMusikk.hentArtistUtvalg("Queen");
        System.out.println("Spiller sanger med Queen hentet fra listen:");
        for (Sang queenSang : queenListe){
            queenSang.spill();
        }
        System.out.println();

        allMusikk.fjernSang(nySang);
        System.out.println("Spiller listen igjen, denne gangen uten slagern fra 78");
        System.out.println();

    }
}
