import java.util.Iterator;

public class Butikk implements Iterable<Person>{

    Person forste = null;
    int antall = 0;

    public void entreButikk(Person p){
        antall++;
        if(forste == null){
            forste = p;
            return;
        }
        else {
            Person peker = forste;
            while(peker.hentNestePerson() != null){
                peker = peker.hentNestePerson();
            }
            peker.settNeste(p);
        }
    }

    private class personIterator implements Iterator<Person>{
        int teller = 0;

        @Override
        public Person next() {
            teller++;
            forste = forste.hentNestePerson();
            return forste;
        }

        @Override
        public boolean hasNext() {
            return teller < hentStoerrelse();
        }

    }

    public int hentStoerrelse(){
        return antall;
    }

    @Override
    public Iterator<Person> iterator(){
        return new personIterator();
    }

    /*
    public void gaaTilKassen(){
        while(hentStoerrelse() != 0){
            System.out.println(forste);
            System.out.println("- Hade bra!" + "\n");
            forste = forste.hentNestePerson();
            antall--;
        }
        System.out.println("Tomt for kunder!");
    }
    */
    
}
