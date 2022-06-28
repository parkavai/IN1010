public class Liste <T extends Comparable<T>>{

    private Node foran;

    private class ListeEnde extends Node{
        boolean erHode;
        ListeEnde(boolean erHode){
            super(null);
            this.erHode = erHode;
        }

        @Override
        int sammenlign(Node k){
            if(erHode){
                return -1;
            }
            else {
                return 1;
            }
        }

        @Override
        void skriv(){
            if(!(erHode)){

            }
            else {
                super.skriv();
            }
        }
    }

    private class Node{
        protected T t;
        protected Node neste;
        Node(T nyttObjekt){
            t = nyttObjekt;
        }

        int sammenlign(Node k){
            return t.compareTo(k.t);
        }

        void settInn(Node ny){
            if(neste.sammenlign(ny) > 0){
                    ny.neste = neste;
                    neste = ny;
                    return;
            }
            else {
                neste.settInn(ny);
            }
        }

        void skriv(){
            System.out.println(t);
            neste.skriv();
        }
    }
    public Liste(){
        ListeEnde listeHode = new ListeEnde(true);
        ListeEnde listeHale = new ListeEnde(false);
        foran = listeHode;
        foran.neste = listeHale;
    }

    public void settInn(T t){
        Node nyNode = new Node(t);
        foran.settInn(nyNode);
    }


    public void skrivAlle(){
        System.out.println("Alle i lista:\n" + "----");
        foran.skriv();
        System.out.println("--SLUTT");
    }
    
}
