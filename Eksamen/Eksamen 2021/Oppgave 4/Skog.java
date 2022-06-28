// Oppgave 4

import java.util.Random;
public class Skog{

    private final int ANTKRYSS;
    private final int ANTSTIER;
    private Kryss[] listeAvKryss;
    private Sti[] listeAvStier;
    private int tilfeldig;
    Skog(int ANTKRYSS, int ANTSTIER){
        this.ANTKRYSS = ANTKRYSS;
        this.ANTSTIER = ANTSTIER;
        listeAvKryss = new Kryss[ANTKRYSS];
        for(int i = 0; i < ANTKRYSS; i++){
            Kryss kryss = new Kryss(null);
            listeAvKryss[i] = kryss;
        }
        listeAvStier = new Sti[ANTSTIER];
        for(int i = 0; i < ANTSTIER; i++){
            int tilfeldigSikt = Trekk.trekkInt(1, 6);
            tilfeldig = Trekk.trekkInt(0, 100);
            Sti sti;
            // Endring fra oppgave 1 for skog
            Kryss kryss1 = hentTilfeldigKryss();
            Kryss kryss2 = hentTilfeldigKryss();
            if(kryss1.equals(kryss2)){
                kryss2 = hentTilfeldigKryss();
            }
            if(tilfeldig <= 25){
                sti = new Kjerrevei(kryss1, kryss2, tilfeldig);
            }
            else if(tilfeldig > 25 && tilfeldig <= 50){
                sti = new Natursti(kryss1, kryss2, tilfeldig);
            }
            else if(tilfeldig > 50 && tilfeldig <= 75){
                sti = new KjerreveiGodUtsikt(kryss1, kryss2, tilfeldig);
            }
            else {
                sti = new NaturstiGodUtsikt(kryss1, kryss2, tilfeldig);
            }
            listeAvStier[i] = sti;
        }
    }

    public Kryss hentTilfeldigKryss(){
        tilfeldig = Trekk.trekkInt(0, listeAvKryss.length);
        return listeAvKryss[tilfeldig];
    }

    public Sti hentTilfeldigSti(){
        tilfeldig = Trekk.trekkInt(0, listeAvStier.length);
        return listeAvStier[tilfeldig];
    }



}