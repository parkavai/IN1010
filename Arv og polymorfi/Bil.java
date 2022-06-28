abstract class Bil { 
    protected double pris;
    protected String nr;
    Bil (String nr, double pris) {
    	this.nr = nr;
    	this.pris = pris;
    }
    public String nummer() {return nr;}
    public abstract double skatt( ); 
}



class Personbil extends Bil {
    Personbil (String nr, double pris) {
    	super(nr, pris);
    }
    protected int antallPassasjer;
    public double skatt( ) {return pris;}
}



class Lastebil extends Bil {
    Lastebil (String nr, double pris) {
    	super(nr, pris);
    }
   protected double lastevekt;
   public double skatt ( ) {return pris * 0.25;}
}



class Taxi extends Personbil {
    Taxi (String nr, double pris) {
    	super(nr, pris);
    }
   protected String loyveId;
   public double skatt ( ) {return  pris *0.1;}
}