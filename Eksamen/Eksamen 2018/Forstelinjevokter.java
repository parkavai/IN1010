class Forstelinjevokter implements Runnable {
    String monster;
    MistenkeligPersoner monitor;
    Flygning flygning;
    Forstelinjevokter(Flygning flygning, String monster, MistenkeligPersoner monitor){
        this.monster = monster;
        this.monitor = monitor;
        this.flygning = flygning;
    }

    @Override 
    public void run(){
        try{
            for(Sete s: flygning){
                if(s.passasjer != null){
                    int prio = inneholder(s.passasjer.navn, monster);
                    if(prio != -1){
                        monitor.leggTilMistenkte(s.passasjer, prio);
                    }
                }
            }
        }
        catch(InterruptedException e){
            System.out.println("Skjedde feil ved forstelinjevokter");
        }
    }

    static int inneholder(String streng, String forekommer){
        int startIndeks = 0;
        int teller = 0;
        int indeksForekommer = 0;
        int vanlig = 0;
        while(vanlig != streng.length()){
            if(streng.charAt(vanlig) == forekommer.charAt(0)){
                startIndeks = vanlig;
            }
            if(indeksForekommer == forekommer.length()){
                break;
            }
            if(streng.charAt(vanlig) == forekommer.charAt(indeksForekommer)){
                teller++;
                indeksForekommer++;
            }
            vanlig++;
        }
        if(teller != forekommer.length()){
            startIndeks = -1;
        }

        return startIndeks;
        
    }
}