public class Avdeling {

    PasientAdm pasientprio;

    final void settInn(Pasient p){
        pasientprio.settInnPasient(p);
    }

    final Pasient hentUt(Pasient p){
        return pasientprio.hentUt(p);
    }

    final Pasient hentUt(int i){
        return pasientprio.hentUt(i);
    }
    
}
