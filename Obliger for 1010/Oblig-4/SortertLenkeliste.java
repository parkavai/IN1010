public class SortertLenkeliste<T extends Comparable<T>> extends Lenkeliste<T> {

    public SortertLenkeliste(){
        super();
    }

    
    @Override
    public void leggTil( T x){
        T leggTilData = x;
        T sjekkData = null;
        if(super.stoerrelse() == 0){
            super.leggTil(x);
            return;
        }
        else {
            for(int i = 0; i < super.stoerrelse(); i++){
                sjekkData = super.hent(i);
                if(sjekkData.compareTo(leggTilData) > 0){
                    super.leggTil(i, leggTilData);           
                    return;
                }
            }
            super.leggTil(leggTilData);
        }
    }

    @Override
    public T fjern(){
        T stoerstData = null;        
        if(super.stoerrelse() == 0){
            throw new UgyldigListeIndeks(-1);
        }
        else if(super.stoerrelse() != 0){
            for(int i = 0; i < super.stoerrelse(); i++){
                T sjekkData = super.hent(i);
                stoerstData = super.hent(super.stoerrelse()-1);
                if(sjekkData.compareTo(stoerstData) > 0){
                    super.fjern(i);
                    return sjekkData;
                }
            }
        }
        super.fjern(super.stoerrelse()-1);
        return stoerstData;
    }

    
    @Override
    public void leggTil(int pos, T x){
        throw new UnsupportedOperationException();
    }

    
    @Override
    public void sett(int pos, T x){
        throw new UnsupportedOperationException();
    }
}