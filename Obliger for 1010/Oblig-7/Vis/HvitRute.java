import java.util.*;

public class HvitRute extends Rute{
    protected ArrayList<Tuppel> stien;
    public HvitRute(int rad, int kolonne, Labyrint labyrintRef){
        super(rad, kolonne,labyrintRef);
        stien = new ArrayList<>();
    }
    
    /**
     * Har to parametere for gaa() metoden hvor jeg blant annet tar 
     * med den Ruten som vi nettopp kom fra og stien vi er foreløpig i. 
     * Jeg syntes det var nødvendig siden ett av basisstegene i denne 
     * rekursjonen er om en hvit-rute ikke er lik den vi kom fra, for da 
     * har vi ingen naboer som stien kan gå videre fra.
     */
    @Override
    public void gaa(Rute komFra, ArrayList<Tuppel> sti) {
        Rute[] arrayAvNaboer = this.hentNaboer(nord, soer, oest, vest);
        Rute foersteSti = null;
        Rute andreSti = null;
        Rute tredjeSti = null;
        Rute fjerdeSti = null;
        // Sjekker at vi ikke er i en åpningsRute
        if(komFra == null){
            return;
        }
        for (Rute nabo: arrayAvNaboer){
            // Utelukker alle naboer av sort rute
            if (nabo != null){
                if(nabo != komFra){
                    // Sørger for å fortsette til neste naborute i stien
                    sti.add(nabo.hentTuppel());
                    if(foersteSti == null){
                        foersteSti = nabo;
                        ArrayList<Tuppel> nySti = new ArrayList<>(sti);
                        foersteSti.gaa(this,nySti);
                    }
                    else if (andreSti == null) {
                        andreSti = nabo;
                        ArrayList<Tuppel> nySti = new ArrayList<>(sti);
                        andreSti.gaa(this,nySti);
                    }
                    else if (tredjeSti == null){
                        tredjeSti = nabo;
                        ArrayList<Tuppel> nySti = new ArrayList<>(sti);
                        tredjeSti.gaa(this,nySti);
                    }
                    else{
                        fjerdeSti = nabo;
                        ArrayList<Tuppel> nySti = new ArrayList<>(sti);
                        fjerdeSti.gaa(this,nySti);
                    }
                }
            }
        }
    }

    @Override
    public void finnUtvei(){
        gaa(this,stien);
    }

    @Override
    public char tilTegn(){
        return '.'; 
    }
    
}
