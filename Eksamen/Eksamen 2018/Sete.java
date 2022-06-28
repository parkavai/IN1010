public class Sete implements Midtgang{
    Passasjer passasjer = null;
    boolean vedMidtgang = false;
    boolean vedVindu = false;
    char seteId;

    Sete(char seteId){
        this.seteId = seteId;
    }

    public boolean erVindusSete(){
        vedVindu = true;
        return vedVindu;
    }

    public void reserver(Passasjer pas){
        this.passasjer = pas;
    }

    @Override
    public boolean erVedMidtgang(){
        vedMidtgang = true;
        return vedMidtgang;
    }
    
}
