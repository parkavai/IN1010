public class Kryss {

    private Sti[] listeAvStier;
    private Sti stien;

    Kryss(Sti[] listeAvStier){
        this.listeAvStier = listeAvStier;
        stien = this.hentTilfeldigSti();
    }

    public Sti hentTilfeldigSti(){
        int tilfeldig = Trekk.trekkInt(0, listeAvStier.length);
        return listeAvStier[tilfeldig];
    }

    public Boolean erIsolert(){
        for(Sti s: listeAvStier){
            if(s != null){
                return false;
            }
        }
        return true;
    }

    public boolean finnesVeiTil(Kryss kryss2){
        if(kryss2.erIsolert()){
            return false;
        }
        else if(stien.finnAndreEnde().equals(kryss2)){
            return true;
        }
        else if(stien.kryss1.finnesVeiTil(kryss2)){
            if(kryss2.equals(stien.kryss1)){
                return true;
            }
            return true;
        }
        // Rekurserer videre skulle ingen av basisstegene inntreffe
        else {
            stien.finnAndreEnde().finnesVeiTil(kryss2);
            // Da betyr det at det ikke fantes en kryss til 
            return false;
        }
    }

}
