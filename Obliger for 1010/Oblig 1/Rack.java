import java.util.ArrayList;

public class Rack {

    private ArrayList<Node> listeAvNoder;
    private int antall = 0;

    Rack(){
        listeAvNoder = new ArrayList<>();
    }

    public void leggTilNode(Node n){
        antall++;
        listeAvNoder.add(n);
    }

    public int hentAntallNoder(){
        return antall;
    }

    public int antallProsessorer(){
        int antProsessorer = 0;
        for (Node n: listeAvNoder){
            antProsessorer += n.antallProsessorer();
        }
        return antProsessorer;
    }

    public int noderMedNokMinne(int paakrevdMinne){
        int antNoder = 0;
        for (Node n: listeAvNoder){
            if(n.noderMedNokMinne(paakrevdMinne) == n.hentMinne()){
                antNoder++;
            }
        }
        return antNoder;
    }
    
}
