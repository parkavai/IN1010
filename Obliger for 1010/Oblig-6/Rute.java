import java.util.*;

public abstract class Rute{
    protected int rad, kolonne;
    protected Rute nord, soer, oest, vest;
    protected Tuppel koordinater;
    protected Labyrint labyrintRef;

    public Rute(int rad, int kolonne, Labyrint labyrintRef){
        this.rad = rad;
        this.kolonne = kolonne;
        this.koordinater = new Tuppel(rad,kolonne);
        this.labyrintRef = labyrintRef;
    }

    // Sørger for at alle sortenaboruter tilsvarer til null
    public Rute[] hentNaboer(Rute nord, Rute soer, Rute oest, Rute vest){
        this.nord = nord;
        this.soer = soer;
        this.oest = oest;
        this.vest = vest;
        if(nord != null){
            if(nord.tilTegn() == '#'){
                nord = null;
            }
        }
        if (soer != null){
            if(soer.tilTegn() == '#'){
                soer = null;
            }
        }
        if (oest != null){
            if(oest.tilTegn() == '#'){
                oest = null;
            }
        }
        if (vest != null){
            if(vest.tilTegn() == '#'){
                vest = null;
            }
        }
        Rute[] naboListe = new Rute[]{nord, soer, oest, vest};
        return naboListe;
    }

    public Tuppel hentTuppel(){
        return koordinater;
    }

    /**
     * Valgte å gjøre gaa() metoden abstrakt siden gjennom polymorfi 
     * så vil den dypest sett objektet utføre gaa() metoden og i dette 
     * tilfellet så vil vi at hviteRuter skal utføre sin gaa() metode.
     */
    abstract void gaa(Rute komFra, ArrayList<Tuppel> sti);

    abstract void finnUtvei();

    abstract char tilTegn();

}

        