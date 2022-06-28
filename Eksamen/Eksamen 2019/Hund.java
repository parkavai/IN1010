class Hund implements Comparable<Hund> {
    String navn;
    Kull mittKull;
    Tidspunkt minFodselstid;
    Hund neste = null;

    Hund(Kull k, String navn, Tidspunkt fodt){
        this.navn = navn;
        mittKull = k;
        minFodselstid = fodt;
    }

    // En hund som er født før en annen hund, kommer først i ordningen
    @Override 
    public int compareTo(Hund h){
        return this.minFodselstid.compareTo(h.minFodselstid);
    }

    public Hund mor(){
        return mittKull.mor;
    }

    public Hund far(){
        return mittKull.far;
    }

    public boolean erHelsosken(Hund h){
        if(this.mor() == null || this.far() == null || h.far() == null || h.mor() == null){
            return false;
        }
        if(this.mor() == h.mor() && this.far() == h.far()){
            return true;
        }
        return false;
    }

    public boolean erHalvsosken(Hund h){
        if(!erHelsosken(h)){
            if(this.mor() == null && this.far() == h.far() || this.far() == null && this.mor() == h.mor()){
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

    public Hund finnEldstKjenteOpphav(){
        if(this.mor() == null && this.far() == null){
            return this;
        }
        if(this.mor() == null){
            this.far().finnEldstKjenteOpphav();
        }
        if(this.far() == null){
            this.mor().finnEldstKjenteOpphav();
        }
        Hund eldsteMor = this.mor().finnEldstKjenteOpphav();
        Hund eldsteFar = this.far().finnEldstKjenteOpphav();
        if(eldsteMor.compareTo(eldsteFar) < 0){
            return eldsteMor;
        }
        else {
            return eldsteFar;
        }
    }
    
    
}
