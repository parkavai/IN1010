public class KjerreveiGodUtsikt extends Kjerrevei{
    KjerreveiGodUtsikt(Kryss ende1, Kryss ende2, int utsiktsVerdi){
        super(ende1, ende2, utsiktsVerdi);
        System.out.println("Denne kjerreveistien har en god utsikt paa: " + utsiktsVerdi);
    }

    @Override
    public boolean harGodUtsikt(){
        return true;
    }
    
}
