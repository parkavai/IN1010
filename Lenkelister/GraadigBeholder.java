public class GraadigBeholder <T extends Comparable<T>> {
    private Node node = null;
    private T gamleData = null;
    
    private class Node {
        T data;
        Node(T d) {
            data = d;
        }
        public T hentData(){
            return data;
        }
    }

    T settInn(T element){
        Node nyNode = new Node(element);
        if(node == null){
            node = nyNode;
            return null;
        }
        else if(nyNode.hentData().compareTo(node.hentData()) >= 0){
            gamleData = node.data;
            node.data = nyNode.data;
            return gamleData;
        }
        return gamleData;
    }

    T taUt(){
        return node.hentData();
    }
    
}

/* Trix oppgave sitt løsningsforslag
public T settInn (T ny) {
    if (mittElement == null) {
        mittElement = ny;
        return null;

    } else if (ny.compareTo(mittElement) >= 0) {
        T midlertidig = mittElement;
        mittElement = ny;
        return midlertidig;

    } else {
        return null;
    }
}

public T seInnhold() {
    return mittElement;
}
}
*/
