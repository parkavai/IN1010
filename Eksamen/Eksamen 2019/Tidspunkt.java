class Tidspunkt implements Comparable<Tidspunkt>{

    // I oppgaven står det at vi ikke trenger get-metoder for instansvariablene så variablene behøver ikke å være private
    int aar, mnd, dag, time, min, sek;

    public Tidspunkt(int aar, int mnd, int dag, int time, int min, int sek){
        this.aar = aar;
        this.mnd = mnd;
        this.dag = dag;
        this.time = time;
        this.min = min;
        this.sek = sek;
    }

    // Antar at tidspunktet kommer før et annet tidspunkt
    @Override
    public int compareTo(Tidspunkt annenTidspunkt){
        if(this.aar != annenTidspunkt.aar){
            return this.aar - annenTidspunkt.aar;
        }
        if(this.mnd != annenTidspunkt.mnd){
            return this.mnd - annenTidspunkt.mnd;
        }
        if(this.dag != annenTidspunkt.dag){
            return this.dag - annenTidspunkt.dag;
        }
        if(this.time != annenTidspunkt.time){
            return this.time - annenTidspunkt.time;
        }
        if(this.min != annenTidspunkt.min){
            return this.min - annenTidspunkt.min;
        }
        return this.sek - annenTidspunkt.sek;
    }


}