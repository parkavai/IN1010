public class Passasjer {

    String navn;
    double hoyde;

    Passasjer(String navn, double hoyde){
        this.navn = navn;
        this.hoyde = hoyde;
    }

    boolean harLangeBen(){
        return hoyde >= 190;
    }
    
}
