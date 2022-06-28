public class LenkelisteElement<T extends Comparable<T>> {

    private ListeHode Ihode;
    private ListeHale Ihale;
    private int antall;

    LenkelisteElement(){
        antall = 0;
        Ihode = new ListeHode(null);
        Ihale = new ListeHale(Ihode, null);
        Ihode.neste = Ihale;
    }

    private interface Elem {

        int compareTo(Elem e);
        void settInnOrdnet(Elem e);
    }

    private class ListeHode implements Elem{

        Elem neste;

        ListeHode(Elem t){
            neste = t;
        }

        /* 
        Årsaken skyldes av at ListeHode vil være på starten av lenkelisten, dermed så må den returnere et negativt tall.
        Da vet vi for en vilkårlig valgt Node (n) som sammenlignes med ListeHale (Ihale), så vil Node (n) være større enn 
        (Ihale) og dermed plasserer foran den siden (Ihale) alltid skal være på starten av lenkelisten. 
        */
        public int compareTo(Elem k){
            return -9; 
        }

        public void settInnOrdnet(Elem k){
            settInnNy((Node) n);
        }

        public void settInnNy(Node ny){
            
        }
    }
    private class ListeHale implements Elem{

        Elem forrige;

        ListeHale(Elem Ihode, Elem t){
            forrige = Ihode;
        }

        /* 
        Årsaken skyldes av at ListeHale vil være på slutten av lenkelisten, dermed så må den returnere et positivt tall.
        Da vet vi for en vilkårlig valgt Node (n) som sammenlignes med ListeHale (Ihale), så vil Node (n) være mindre enn 
        (Ihale) og dermed plasserer bak den. 
        */
        public int compareTo(Elem k){
            return 9; 
        }

        public void settInnOrdnet(Elem k){
            System.out.println("Kan ikke kalle på settInnOrdnet for listeHale");
        }
    }

    private class Node implements Elem{
        T obj;
        Elem neste;

        Node(T t){
            obj = t;
        }

        public int compareTo(Elem k){
            return obj.compareTo(((Node) k).obj);
        }

        public void settInnOrdnet(Elem k){
            if (neste.compareTo(k) < 0){
                this.neste.settInnOrdnet(k);
            }
            else if (this.compareTo(k) > 0){
                Node ny = (Node) k;
                ny.neste = this.neste;
                neste = ny;
                if(ny.neste == Ihale){
                    Ihale.forrige = k;
                    antall++;
                }
            }
            
        }
    }

    public int antall() {
        return antall;
    }

    public void settInnOrdnet(T nyComparable){
        Node nyNode = new Node(nyComparable);
        Ihode.settInnOrdnet(nyNode);
    }

    public void settInnBak(T nyComparable){
        Node nyNode = new Node(nyComparable);
        if(erTom()){
            Ihale.forrige = Ihode;
        }
        else {
            Ihale.forrige.neste = nyNode;
            Ihale.forrige = nyNode;
            nyNode.neste = Ihale;
            antall++;
        }
    }


    public T taUtForan() throws Exception{
        T data = null;
        if(Ihode.neste != null){
            Node tmp = Ihode.neste;
            Ihode.neste = tmp.neste;
            data = tmp.obj;
            antall--;
            return data;
        }
        else {
            throw new Exception("Kalles på tom-liste, legg til elementer");
        }

    }

    public boolean erTom(){
        
    }

    
}
