import java.util.ArrayList;
import java.util.Iterator;

public class Flygning implements Iterable<Sete>{

    ArrayList<Seterad> listeAvSeteRadene = new ArrayList<>(); 
    ArrayList<Sete> listeAvSeterPerRad = new ArrayList<>();
    String seteinfo;
    String type;
    String flightNo;
    int radNummer;
    int teller = -1;
    Flygning(String type, String seteinfo){
        this.type = type;
        this.seteinfo = seteinfo;
        for(int i = 0; i < seteinfo.length(); i++){
            char tegn = seteinfo.charAt(i);
            Sete sete;
            if(tegn != ':'){
                if(i == 0){
                    radNummer = i;
                }
                else if(tegn == '|'){
                    Seterad seterad = new Seterad(radNummer, listeAvSeterPerRad);
                    listeAvSeteRadene.add(seterad);
                    listeAvSeterPerRad = new ArrayList<>();
                    radNummer = seteinfo.charAt(i+1);
                }
                else if(tegn == '*'){
                    listeAvSeterPerRad.get(teller).erVedMidtgang();
                }
                else if(tegn == '+'){
                    sete = new GodBenplassSete(listeAvSeterPerRad.get(teller).seteId);
                    listeAvSeterPerRad.remove(teller);
                    listeAvSeterPerRad.add(sete);
                }
                else {
                    sete = new Sete(tegn);
                    listeAvSeterPerRad.add(sete);
                    teller++;
                }
            }
        }
    }

    class SeteListeIterator implements Iterator<Sete>{
        int seteIndeks, radIndeks;
        Sete sete;

        @Override
        public boolean hasNext(){
            return radIndeks <= listeAvSeteRadene.size();
        }

        @Override
        public Sete next(){
            sete = listeAvSeteRadene.get(radIndeks).listeAvSeter.get(seteIndeks);
            if(seteIndeks >= listeAvSeteRadene.get(radIndeks).listeAvSeter.size()){
                radIndeks++;
                seteIndeks = 0;
            }
            seteIndeks++;
            return sete;
        }

    }

    @Override
    public Iterator<Sete> iterator(){
        return new SeteListeIterator();
    }

    public boolean book(Passasjer pas){
        for(Seterad seterad: listeAvSeteRadene){
            for(Sete sete: seterad.listeAvSeter){
                if(sete.passasjer == null){
                    sete.reserver(pas);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean book(Passasjer pas, boolean foretrekkerVindu, boolean foretrekkerMidtgang){
        for(Seterad seterad: listeAvSeteRadene){
            for(Sete sete: seterad.listeAvSeter){
                if(foretrekkerVindu == true){
                    if(sete.vedVindu == true){
                        sete.reserver(pas);
                        return true;
                    }
                    
                }
                else if(foretrekkerMidtgang == true){
                    if(sete.vedMidtgang == true){
                        sete.reserver(pas);
                        return true;
                    }

                }
                else if(pas.harLangeBen()){
                    if(sete.passasjer != null){
                        sete.reserver(pas);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean book(Passasjer pas1, Passasjer pas2){
        int teller = 0;
        int nesteSete = 1;
        for(Seterad seterad: listeAvSeteRadene){
            int sjekk = 0;
            for(Sete sete: seterad.listeAvSeter){
                sjekk++;
                if((sete.vedMidtgang != true)){
                    if(sete.passasjer == null){
                        sete.passasjer = pas1;
                        teller++;
                        nesteSete = sjekk;
                    }
                    else if(seterad.listeAvSeter.get(nesteSete) == null){
                        sete.passasjer = pas2;
                        teller++;
                    }
                }
            }
        }
        if(teller == 2){
            return true;
        }
        else {
            return false;
        }
    }

    public void skriv(){
        for(Seterad seterad: listeAvSeteRadene){
            System.out.println("Seterad nr: " + seterad.rad);
            for(Sete sete: seterad.listeAvSeter){
                System.out.println("Passasjer: " + sete.passasjer.navn +  " med hoyde: " + sete.passasjer.hoyde + "\n");
                if(sete.passasjer.harLangeBen()){
                    System.out.println("sitter i sete" + sete.seteId + " som har god benplass " + "\n");
                }
                else {
                    System.out.println("sitter i sete" + sete.seteId + "\n");
                }
            }
        }
    }
    
}
