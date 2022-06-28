public class GodBenplassSete extends Sete{

    GodBenplassSete(char seteId){
        super(seteId);
    }

    @Override
    public void reserver(Passasjer pas){
        if (pas.harLangeBen()){
            passasjer = pas;
        }
    }
    
}
