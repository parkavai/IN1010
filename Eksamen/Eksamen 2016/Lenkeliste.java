public class Lenkeliste<T extends Comparable<T>> {

    private ListeHode Ihode;
    private ListeHale Ihale;
    private int antall;

    Lenkeliste(){
        antall = 0;
        Ihode = new ListeHode(null);
        Ihale = new ListeHale(Ihode, null);
        Ihode.neste = Ihale;
    }

    private abstract class AbstrNode{
        T obj;
        AbstrNode neste;

        AbstrNode(T t){
            obj = t;
            neste = null;
        }

        abstract int compareTo(AbstrNode k);
        abstract void settInnOrdnet(AbstrNode k);
    }

    private class ListeHode extends AbstrNode{

        ListeHode(T t){
            super(t);
        }

        /* 
        Årsaken skyldes av at ListeHode vil være på starten av lenkelisten, dermed så må den returnere et negativt tall.
        Da vet vi for en vilkårlig valgt Node (n) som sammenlignes med ListeHale (Ihale), så vil Node (n) være større enn 
        (Ihale) og dermed plasserer foran den siden (Ihale) alltid skal være på starten av lenkelisten. 
        */
        int compareTo(AbstrNode k){
            return -9; 
        }

        void settInnOrdnet(AbstrNode k){
            if(neste.compareTo(k) <= 0){
                k.neste = neste;
                neste = k;
                antall++;
            }
            if(k.neste == Ihale){
                Ihale.forrige = k;
                antall++;
            }
            else {
                neste.settInnOrdnet(k);
            }
        }
    }
    private class ListeHale extends AbstrNode{

        AbstrNode forrige;

        ListeHale(AbstrNode Ihode, T t){
            super(t);
            forrige = Ihode;
        }

        /* 
        Årsaken skyldes av at ListeHale vil være på slutten av lenkelisten, dermed så må den returnere et positivt tall.
        Da vet vi for en vilkårlig valgt Node (n) som sammenlignes med ListeHale (Ihale), så vil Node (n) være mindre enn 
        (Ihale) og dermed plasserer bak den. 
        */
        int compareTo(AbstrNode k){
            return 9; 
        }

        void settInnOrdnet(AbstrNode k){
            System.out.println("Kan ikke kalle på settInnOrdnet for listeHale");
        }
    }

    private class Node extends AbstrNode{

        Node(T t){
            super(t);
        }

        int compareTo(AbstrNode k){
            return obj.compareTo(k.obj);
        }

        void settInnOrdnet(AbstrNode k){
            if (this.compareTo(k) < 0){
                this.neste.settInnOrdnet(k);
            }
            else if (this.compareTo(k) >= 0){
                k.neste = this.neste;
                neste = k;
                if(k.neste == Ihale){
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
            AbstrNode tmp = Ihode.neste;
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
        if(antall() > 0){
            return true;
        }
        else {
            return false;
        }
    }

    
}
