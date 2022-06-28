import java.util.*;

public class HashMapBeholder {

    ArrayList<HashMap<String, SubSekvens>> listeAvHashMap;
    int antall = 0;

        public HashMapBeholder() {
            listeAvHashMap = new ArrayList<>();
        }

        public void leggeTilHashMap(HashMap<String, SubSekvens> hashMap){
            antall ++;
            listeAvHashMap.add(hashMap);
        }

        public HashMap<String, SubSekvens> taUtHashMap() {
            antall --;
            return listeAvHashMap.remove(0); 
        }

        public int hentAntallHashMaps(){
            return listeAvHashMap.size();
        }


        public int antall() {
            return antall;
        }

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