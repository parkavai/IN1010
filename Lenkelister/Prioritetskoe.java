public class Prioritetskoe<T> {

    private class Node {
        T data;
        Node neste;
        int prioritet;
        Node(T d, int prio) {
            data = d;
            neste = null;
            this.prioritet = prio;
        }
        public T hentData(){
            return data;
        }
        public int hentPrio(){
            return prioritet;
        }
    }
    Node start = null;
    int antall = 0;

    void settInn(T inn, int prio){
        Node nyNode = new Node(inn, prio);
        antall ++;
        if(start == null){
            start = nyNode;
            return;
        }
        else if (nyNode.hentPrio() <= start.hentPrio()){
            nyNode.neste = start;
            start = nyNode;
        }
        else {
            Node temp = start;
            while (temp != null && temp.hentPrio() < nyNode.hentPrio()){
                temp = temp.neste;
            }
            nyNode.neste = temp.neste;
            temp.neste = nyNode;
        }

    }

    T taUt(){
        T foerste = start.hentData();
        start = start.neste;
        antall --;
        return foerste;
    }

    int antall(){
        return antall;
    }


    
}
