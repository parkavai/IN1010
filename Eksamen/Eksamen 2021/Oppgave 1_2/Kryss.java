// Oppgave 1 c.)

public class Kryss {

    private Sti[] listeAvStier;

    Kryss(Sti[] listeAvStier){
        this.listeAvStier = listeAvStier;
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




    
}
