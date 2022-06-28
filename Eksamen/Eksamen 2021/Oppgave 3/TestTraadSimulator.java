public class TestTraadSimulator {
    
    // Bruker noen av de samme verdier som fra oppgave 2 men tilpasses for traader
    // Ikke noedvendig med barriere da main-traaden ikke behoever aa vente paa at traadene blir ferdige
    public static void main(String[] args) {
        final int ANTTURGAAER = 10;
        Skog skogen = new Skog(100, 100);
        for(int i = 0; i <= ANTTURGAAER; i++){
            int hastighet = Trekk.trekkInt(20, 200);
            Turgaaer turgaaer = new Turgaaer(hastighet, skogen.hentTilfeldigKryss());
            Thread traad = new Thread(turgaaer);
            traad.start();
        }
    }
    
}
