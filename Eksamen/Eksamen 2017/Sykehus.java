public class Sykehus {
    Avdeling akuttAvd, senger;

    void skrivInn(Pasient p, Avdeling a){
        a.settInn(p);
    }

    void overFoer(Pasient p, Avdeling fra, Avdeling til){
        if(fra.hentUt(p) != null){
            til.settInn(p);
        }
    }

    void skrivUt(Pasient p, Avdeling a){
        a.hentUt(p);
    }

    void utforAnalyse(PasientPrio pasientPrio, int antAnalyse){
        AnalyseBuffer buffer = new AnalyseBuffer();
        for(int i = 0; i < pasientPrio.MAXPASPRIO; i++){
            Sil sil = new Sil(pasientPrio, buffer, i);
            Thread traad = new Thread(sil);
            traad.start();
        }
        for (int i = 0; i < antAnalyse; i++){
            Analyse analyse = new Analyse(pasientPrio, buffer);
            Thread traad = new Thread(analyse);
            traad.start();
        }

    }

    public static void kanHaSykdomKvinne(Pasient p){

    }

    public static void kanHaSykdomMann(Pasient p){
        
    }

    public static boolean iFaresonenMann(Pasient p){
        return true;
    }

    public static boolean iFaresonenKvinne(Pasient p){
        return true;   
    }
    public static void main(String[] args) {
        /*
        Oppgave 4 b.)
        Pasient akutt1 = new Pasient("Arne", 1);
        Pasient akutt2  = new Pasient("Steve", 2);
        Sykehus hospitalet = new Sykehus();
        hospitalet.skrivInn(akutt1, hospitalet.akuttAvd);
        hospitalet.skrivInn(akutt2, hospitalet.akuttAvd);
        hospitalet.overFoer(akutt2, hospitalet.akuttAvd, hospitalet.senger);
        hospitalet.skrivUt(akutt2, hospitalet.akuttAvd);
        */
    }

    
}
