import java.util.*;

public class HashMapBeholder {

    ArrayList<HashMap<String, SubSekvens>> listeAvHashMap;
    int antall = 0;

        public HashMapBeholder() {
            listeAvHashMap = new ArrayList<>();
        }

        public void leggeTilHashMap(HashMap<String, SubSekvens> samletMap) {
            antall ++;
            listeAvHashMap.add(samletMap);
        }

        public HashMap<String, SubSekvens> taUtHashMap(){
            antall --;
            return listeAvHashMap.remove(0);
        }

        public void testHele () {
            System.out.println(" Utskrift av antallet i hver hashmap i beholderen; ");
            for  (HashMap<String,SubSekvens> hashN: listeAvHashMap)
                   System.out.println(" Storrelsen av HashMap:  " + hashN.size() );
        } 

        public int hentAntallHashMaps(){
            return listeAvHashMap.size();
        }


        public int antall() {
            return antall;
        }

        /**
         * Statisk metode som sørger for fletting av to hashMaps som oppbevarer subSekvensene. 
         * Viktig å ta hensyn til at den ene hashmappen kan inneholde identiske subsekvenser som i den andre. 
         * Skulle det være tilfelle så må vi øke antall forekomster og ikke legge til flere av den samme typen. 
         */
        static HashMap<String, SubSekvens> fletting(HashMap<String, SubSekvens> map1, HashMap<String, SubSekvens> map2) {
            HashMap<String, SubSekvens> samletMap = new HashMap<>();
            for (String noekkel: map1.keySet()) {
                samletMap.put(noekkel, map1.get(noekkel));
            }
            for (String noekkel: map2.keySet()) {
                if (samletMap.containsKey(noekkel)){
                    samletMap.get(noekkel).oekAntallForekomster(map2.get(noekkel).hentAntallForekomster());
                }
                else {
                    samletMap.put(noekkel, map2.get(noekkel));
                }
            }
            return samletMap;
        }
    
}