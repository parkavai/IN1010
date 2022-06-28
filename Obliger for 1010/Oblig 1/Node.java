public class Node{

    private int minne, antProsessor;

    Node(int minne, int antProsessor){
        this.minne = minne;
        this.antProsessor = antProsessor;
    }

    public int hentMinne(){
        return minne;
    }

    public int antallProsessorer(){
        return antProsessor;
    }

    public int noderMedNokMinne(int paakrevdMinne){
        if (this.hentMinne() >= paakrevdMinne){
            return minne;
        }
        else {
            return 0;
        }
    }

}