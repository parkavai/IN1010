import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Virus {
    HashMapBeholder beholderForVirus = new HashMapBeholder();
    static int subSekvensLengde = 3;
    
    public void LagVirus(String filnavn) {
        String linje;
        try {
            Scanner leser = new Scanner(new File(filnavn));		
			System.out.println(" Velkommen til HashBeholder test hovedprogram ");
	    	while(leser.hasNextLine()) {
				linje = leser.nextLine();   
	       		linje = linje.trim();
	    		lesInnFil(linje, beholderForVirus);		
			}
            leser.close();
        }
        catch (FileNotFoundException exception) {
            System.out.println("FEIL i filInnlesningen" + filnavn + ", husk å bruke metadatafilen."); 
        }
        System.out.println( );	
		beholderForVirus.testHele();

        while (beholderForVirus.antall() != 1) {
            HashMap<String, SubSekvens> nyMap = HashMapBeholder.fletting(beholderForVirus.taUtHashMap(),beholderForVirus.taUtHashMap());
            beholderForVirus.leggeTilHashMap(nyMap);
        }

        System.out.println(" FERDIG med å samle data ");

        HashMap<String,SubSekvens> hSyk = beholderForVirus.taUtHashMap();		
     	System.out.println( );	
        System.out.println(" Indikatorer på syke pasienter  " );
		for  (SubSekvens sS: hSyk.values()) {
		    if(sS.hentAntallForekomster() > 7){
                System.out.println( sS.hentNoekkel() + "  med antall:   " + sS.hentAntallForekomster());
            }
		}	
		System.out.println(" FERDIG. Programmet terminerer. ");
    }

    /**
     * Legger inn hashMaps for hver linje i filen inn i HashMapBeholderen beholderForVirus
     * Metoden sørger for at vi ikke legger inn duplikater og det er viktig å sørge for at  
     * det ikke er mulig å lage en subString når man nærmer seg slutten av linjen. 
     */
    public void lesInnFil(String filnavn, HashMapBeholder alleData) {
        File fil = new File(filnavn);
        try{
            Scanner leser = new Scanner(fil);
            String linje = "";
            HashMap <String, SubSekvens> virusOrdbok = new HashMap<>();
            while(leser.hasNextLine()) {
                linje = leser.nextLine();
                int lengde = linje.length();
                for (int i = 0; (i+subSekvensLengde) <= lengde; i++){
                    String nySubStreng = linje.substring(i, (i+subSekvensLengde));
                    SubSekvens subSekvens = new SubSekvens(nySubStreng);
                    if (!(virusOrdbok.containsKey(nySubStreng))){
                        virusOrdbok.put(nySubStreng, subSekvens);
                    } 
                    else {
                        virusOrdbok.get(nySubStreng).oekAntallForekomster(1);
                    }
                } 
            }
        leser.close();
        alleData.leggeTilHashMap(virusOrdbok);
        }
        catch(FileNotFoundException exception){
            System.out.println("Fant ikke filen" + filnavn);
        }
}

}