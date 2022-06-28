public class FIFOListe<T>{

	private Node hode;
	private Node hale;
    private int storrelse;

	private class Node {
        Node neste;
        T verdi;
        Node(T verdi){
            this.verdi = verdi;
        }
    }

	public int storrelse(){
        // return storrelse;
        int teller = 0;
        for (Node tmp = hode; tmp != null; tmp = tmp.neste) {
            teller++;
        }
        return teller;
    }

	public boolean erTom() {
        return hode == null;
    }

	public void leggTil(T x) {
        Node nyNode = new Node(x);
        if (erTom()){
            hode = nyNode;
        } else {
            hale.neste = nyNode;
        }
        hale = nyNode;
    }

	public void fjernAlt() {
        hode = null;
        hale = null;
    }

	public T pop(){
        T retur = hode.verdi;
        hode = hode.neste;
        return retur;
    }

	public void skrivUtListe() {
        Node gjeldende = hode;
        String penStreng = "[";
        while (gjeldende != null){
            penStreng += gjeldende.verdi.toString() + ", ";
            gjeldende = gjeldende.neste;
        }
        penStreng += "\b\b]";
        System.out.println(penStreng);
    }
    /*
    @Override
    public Iterator<T> iterator() {
        return new FIFOIterator();
    }

    private class FIFOIterator implements Iterator<T> {
        Node denne = hode;
        
        @Override
        public boolean hasNext() {
            return denne != null;
        }
        
        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException("next");
            Node tmp = denne;
            denne = denne.neste;
            return tmp.verdi;
        }
    }
    */
}