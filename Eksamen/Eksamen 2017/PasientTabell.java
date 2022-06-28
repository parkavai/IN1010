public class PasientTabell extends PasientAdm{

    private Pasient[] pasientListe;
    private int antall = 0;

    PasientTabell(int lengde){
        pasientListe = new Pasient[lengde];
    }

    @Override
    public void settInnPasient(Pasient p){
        if(pasientListe[antall] == null){
            pasientListe[antall] = p; 
            p.settSengeNr(antall);
            antall++;
        }
        else if (antall >= pasientListe.length){
            antall = 0;
            return;
        }
        else {
            p.settNeste(pasientListe[p.sengNr]);
        }
    }

    @Override
    public Pasient hentUt(Pasient p){
        pasientListe[p.sengNr] = null;
        p.settSengeNr(-1);
        return p;
    }

    @Override
    public Pasient hentUt(int prioritet){
        Pasient pasient = null;
        for(int i = 0; i < pasientListe.length; i++){
            if(pasientListe[i] != null){
                if(pasientListe[i].hentPrio() == prioritet){
                    pasient = pasientListe[i];
                }
            }
        }
        return pasient;
    }


    
}
