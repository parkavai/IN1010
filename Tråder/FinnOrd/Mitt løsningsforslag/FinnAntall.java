import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FinnAntall {
    public static void main(String[] args) throws FileNotFoundException{
        File fil = new File("sevenrays.txt");
        Scanner lesInnFil = new Scanner(fil);
        int lengde = Integer.parseInt(lesInnFil.nextLine());
        String[] array = new String[lengde];
        String ord = args[0];
        int teller = 0;
        while (lesInnFil.hasNext()){
            String linje = lesInnFil.nextLine();   
            linje = linje.trim();
            String lestOrd = "";
            for (int i = 0; i < linje.length(); i++){
                char tegnet = linje.charAt(i);
                String tegn = String.valueOf(tegnet);
                if((tegnet != '.') && (tegnet != ',') && (tegnet != '?') && (tegnet != ':') && (tegnet != ';')){
                    lestOrd += tegn;
                }
            }
            array[teller] = lestOrd;
            teller++;
        }
        System.out.println("Skal finne forekomster av ordet: " + ord);
        ArrayList <ArrayList<String>> liste = new ArrayList<>();
        int konstant = (array.length/9);
        teller = (array.length/9);
        for (int i = 0; i < 9; i++){
            ArrayList<String> strenger = new ArrayList<>(); 
            for(int s = 0; s < lengde; s++){
                strenger.add(array[s]);
                if(s == teller){
                    liste.add(strenger);
                    teller += konstant;
                    strenger = new ArrayList<>();
                }
            }
        }
        CountDownLatch barriere = new CountDownLatch(liste.size());
        Monitor monitor = new Monitor();
        for(ArrayList<String> s: liste){
            TraadFinnForekomst runnable = new TraadFinnForekomst(barriere, s, ord, monitor);
            Thread traad = new Thread(runnable);
            traad.start();
        }

        try {
            barriere.await();
        }
        catch (InterruptedException e){
            System.out.println("Feil ved barriere");
        }

        int forekomst = monitor.hentListeAvForekomster().get(0);
        int id = 0;
        for(int i: monitor.hentListeAvForekomster()){
            if(i > forekomst){
                forekomst = i;
                id++;
            }
        }
        String linje = "";
        linje += "Størst forekomst av ordet '" + ord + "', ";
        linje += " med et antall på: " + forekomst + "\n";
        System.out.println(linje);
    }

}

class Monitor {
    final Lock las;
    ArrayList<Integer> listeAvForekomster;
    Monitor(){
        las = new ReentrantLock();
        listeAvForekomster = new ArrayList<>();
    }

    void lasForLeggTil(int forekomster){
        las.lock();
        try {
            listeAvForekomster.add(forekomster);
        }
        finally{
            las.unlock();
        }
    }

    ArrayList<Integer> hentListeAvForekomster(){
        return listeAvForekomster;
    }


}

class TraadFinnForekomst implements Runnable{
    CountDownLatch latch;
    ArrayList<String> subArray;  
    String ord;
    int antall = 1;
    Monitor monitor;

    TraadFinnForekomst(CountDownLatch latch, ArrayList<String> subArray, String ord, Monitor monitor){
        this.latch = latch;
        this.subArray = subArray;
        this.ord = ord;
        this.monitor = monitor;
    }

    public void run() {
        try {
            monitor.lasForLeggTil(tellForekomst());
            Thread.sleep(500);
            latch.countDown();
        }
        catch(InterruptedException e) {
            System.out.println("ss");
        }
    }

    int tellForekomst(){
        for (String s: subArray){
            if(s.equals(ord)){
                antall++;
            }
        }
        return antall;
    }
}
