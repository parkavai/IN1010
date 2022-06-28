public class Prioritetskoe<T>{
    Node start = null; 
    int antall = 0;

    private class Node{
        T data; 
        Node neste = null;
        int prio;

        Node(T data, int prio){
            this.data = data;
            this.prio = prio;
        }

        public T hentData(){
            return this.data;
        }
    }

    public void settInn(T inn, int prio){
        Node nyNode = new Node(inn, prio);
        antall++;
        if(start == null){
            start = nyNode;
        }
        else if(nyNode.prio <= start.prio){
            nyNode.neste = start;
            start = nyNode;
        }
        else {
            Node iterNode = start;
            while (iterNode.neste != null && iterNode.prio < nyNode.prio){
                iterNode = iterNode.neste;
            }
            nyNode.neste = iterNode.neste;
            iterNode.neste = nyNode;
        }
    }

    public T taUt(){
        if(antall < 0){
            return null;
        }
        Node tmp = start;
        start = tmp.neste;
        antall--;
        return tmp.hentData();
    }

    public int antall(){
        return antall;
    }

    public String toString(){
        Node tmp = start;
        String linje = null;
        int teller = 0;
        while (tmp != null){
            linje += "\n" + "Node nr: " + teller + " sin data er: "+ tmp.hentData() + "\n";
            tmp = tmp.neste;
            teller++;
        }
        return linje;
    }
}