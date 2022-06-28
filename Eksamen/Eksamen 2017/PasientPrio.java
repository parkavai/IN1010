public class PasientPrio extends PasientAdm{
    /* 
    FIFO (First in, first out)
    Skal bestå av en liste, hvor hver indeks representerer prioriteten. 
    Indeksen henviser til en lenkeliste hvor lenkelisten består av alle pasienter 
    med den gitte prioriteten som indeksen representer.
    */
    int MAXPASPRIO;
    private Pasient[] arrayEnMedPekerForan;
    private Pasient[] arrayEnMedPekerBak;
    private int prioritet;
    PasientPrio(){
        arrayEnMedPekerForan = new Pasient[MAXPASPRIO +1];
        arrayEnMedPekerBak = new Pasient[MAXPASPRIO +1];
    }

    @Override
    public void settInnPasient(Pasient p){
        int prioritet = p.hentPrio();
        for (int i = 0; i < MAXPASPRIO; i++){
            Pasient lenkeliste = arrayEnMedPekerForan[i];
            if (lenkeliste == null){
                lenkeliste = p;
                return;
            }
            while(lenkeliste.hentNeste() != null){
                lenkeliste = lenkeliste.hentNeste();
            }
            if(lenkeliste != null){
                p.settNeste(lenkeliste);
                lenkeliste = p;
                return;
            }
        }
    }

    @Override
    public Pasient hentUt(int i){
        return hentUt(arrayEnMedPekerForan[i]);
    }

    // Returnerer lenkeliste av pasient etter prioritering
    @Override
    public Pasient hentUt(Pasient p){
        Pasient pektPaa = null;
        for (int i = 0; i < (MAXPASPRIO+1); i++){
            if(arrayEnMedPekerForan[i] != null){
                if(i == p.hentPrio()){
                    pektPaa = arrayEnMedPekerForan[i];
                }
            }
        }
        // Kan hende at det ikke er lagt til pasienter for den prioriteten enda
        if(pektPaa == null){
            return null;
        }
        else {
            // Starten av lista
            if(pektPaa == p){
                pektPaa.settNeste(p.hentNeste());
                return p.hentNeste();
            }
            while(pektPaa.hentNeste() != null && p.hentNeste() != pektPaa){
                pektPaa = pektPaa.hentNeste();
            }
            if(p.hentNeste() == pektPaa){
                p.settNeste(pektPaa.hentNeste());
                return pektPaa;
            }
            else {
                return null;
            }
        }
    }


}
