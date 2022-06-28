// Oppgave 1 c.)

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
            if(tilfeldig <= 25){
                 sti = new Kjerrevei(hentTilfeldigKryss(), hentTilfeldigKryss(), tilfeldig);
            }
            else if(tilfeldig > 25 && tilfeldig <= 50){
                sti = new Natursti(hentTilfeldigKryss(), hentTilfeldigKryss(), tilfeldig);
            }
            else if(tilfeldig > 50 && tilfeldig <= 75){
                sti = new KjerreveiGodUtsikt(hentTilfeldigKryss(), hentTilfeldigKryss(), tilfeldig);
            }
            else {
                sti = new NaturstiGodUtsikt(hentTilfeldigKryss(), hentTilfeldigKryss(), tilfeldig);
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