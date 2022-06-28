import java.util.Iterator;

abstract class Kull implements Iterable<Hund>{

    Hund mor, far;

    Kull(Hund mor, Hund far){
        this.mor = mor;
        this.far = far;
    }

    public abstract void settInnHund(Hund h);
    public abstract Iterator<Hund> iterator();
    
}
