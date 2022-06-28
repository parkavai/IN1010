// Oppgave 2 d.)

public class PrioKoe<Aktivitet extends Comparable<Aktivitet>>{
    Node start = null;
    Node slutt = null;
    
    // Lage en indre klasse node siden det oppstod problemer ved aa kalle en aktivitet sin hoyere og lavere peker. 
    private class Node {
        Aktivitet aktivitet;
        Node neste;
        Node forrige;
        Node(Aktivitet aktivitet) {
            this.aktivitet = aktivitet;
            neste = null;
            forrige = null;
        }
    }


    public void settInn(Aktivitet a){
        Node ny = new Node(a);
        if(slutt == null){
            slutt = ny;
            return;   
        }
        else if(start == null){
            start = ny;
            slutt.forrige = start;
            start.neste = slutt;
            return;
        }
        else if(slutt.aktivitet.compareTo(ny.aktivitet) == 1){
            Node tmp = slutt;
            slutt.forrige.neste = tmp;
            tmp.neste = ny;
            ny.forrige = tmp;
            slutt = ny;
        }
        else {
            Node tmp = slutt;
            while(tmp.forrige != start && tmp.aktivitet.compareTo(ny.aktivitet) != 1){
                tmp = tmp.forrige;
            }
            if (tmp == start){
                if(ny.aktivitet.compareTo(start.aktivitet) == -1){
                    Node midlertidig = start;
                    ny.neste = midlertidig;
                    start = ny;
                    start.neste = ny;
                }
            }
            else if (tmp.aktivitet.compareTo(ny.aktivitet) == 1){
                tmp.neste.forrige = ny;
                ny.neste = tmp.neste;
                tmp.neste = ny;
                ny.forrige = tmp;
            }
        }
        
    }

    public Aktivitet hentUt(){
        if(start == null){
            return null;
        }
        Node tmp = start;
        start = tmp.neste;
        return tmp.aktivitet;
    }
}