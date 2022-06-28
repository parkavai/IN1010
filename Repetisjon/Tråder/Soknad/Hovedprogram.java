import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Scanner;
import java.util.*;
import java.io.File;
import java.util.concurrent.locks.*;

class Hovedprogram{

    static String[] boligNavn = {"Sogn", "Vestgrensa", "Kringsjå"};
    static String[] soknadFiler = {"soknader1.txt", "soknader2.txt", "soknader3.txt", "soknader4.txt", "soknader5.txt"};
    public static void main(String[] args) {
      Monitor monitor = new Monitor(soknadFiler.length);
      for(String soknadFil: soknadFiler){
        Thread t= new Thread(new SoknadsBehandler(new File(soknadFil), monitor));
        t.start();
      }
  
      for(String navn: boligNavn){
        Thread t = new Thread(new Boligsjef(monitor, navn));
        t.start();
      }
    }
  }

class SoknadsBehandler implements Runnable{

    File fil;
    Monitor monitor;
    SoknadsBehandler(File fil, Monitor monitor){
      this.fil = fil;
      this.monitor = monitor;
    }
  
    @Override
    public void run(){
      Scanner scanner = null;
  
      try{
        scanner = new Scanner(fil);
      }catch(Exception e){
        System.out.println(e);
        return;
      }
  
      while(scanner.hasNextLine()){
        String[] linje = scanner.nextLine().split(" ");
        boolean oslo = true;
        if(linje[1].equals("nei")){
          oslo = false;
        }
        int alder = Integer.parseInt(linje[2]);
        boolean rikeForeldre = true;
        if(linje[3].equals("nei")){
          rikeForeldre = false;
        }
        monitor.leggTilSoknad(new Soknad(linje[0], Soknad.prioritering(oslo, alder, rikeForeldre)));
        try{
          Thread.sleep(10000);
        }catch(Exception e){
          System.out.println(e);
        }
      }
  
      //signaliserer til monitoren at denne tråden er ferdig med å jobbe
      monitor.leggTilSoknad(null);
    }
  }

class Monitor{

    private int antallBehandlere;
    private Lock laas = new ReentrantLock();
    private LinkedList<Soknad>[] soknader = new LinkedList[10];
    private int antallFerdige = 0;
    private Condition ingenSoknad = laas.newCondition();
  
    Monitor(int antallBehandlere){
      this.antallBehandlere = antallBehandlere;
      //oppretter alle søknadene
      for(int i = 0; i < soknader.length; i++){
        soknader[i] = new LinkedList<Soknad>();
      }
    }
  
    public void leggTilSoknad(Soknad soknad){
      laas.lock();
      try{
        if(soknad == null){
          antallFerdige++;
        }else{
          soknader[soknad.hentPrioritering()].add(soknad);
        }
        ingenSoknad.signal(); //signaliserer at det er lagt til en søknad
      }finally{
        laas.unlock();
      }
    }
  
    public Soknad hentUtSoknad(){
      Soknad soknad = null;
      laas.lock();
      try{
        while(ingenSoknad() && (antallFerdige != antallBehandlere)){
          ingenSoknad.await(); //venter til det blir signalisert om at det er klart
        }
        //hvis vi er ferdig signaliserer monitoren det med å sende null
        if(ingenSoknad() && antallFerdige == antallBehandlere){
          ingenSoknad.signal(); //må åpne opp for de andre Boligsjefene som venter
          return null;
        }
        int teller = 0;
        while(soknader[teller].isEmpty()){
          teller++;
        }
        soknad = soknader[teller].remove(0);
      }
      catch(Exception e){
        System.out.println(e);
      }
      finally{
        laas.unlock();
      }
      return soknad;
    }
  
    //sjekker om det om arrayet har noen lenkelister med soknader i seg
    //returnerer true hvis det ikke er noen, false ellers
    private boolean ingenSoknad(){
      for(int i = 0; i < soknader.length; i++){
        if(!soknader[i].isEmpty()){
          return false;
        }
      }
      return true;
    }
}

class Soknad{
    private String navn;
    private int prioritering;
    private int soknadsnr;
    private static int soknadsnrGenerator = 0;
    private static Lock laas = new ReentrantLock();
  
    Soknad(String navn, int prioriteting){
      this.navn = navn;
      this.prioritering = prioriteting;
  
      //siden soknadsnrGenerator er static kan flere traader bruke skrive til denne
      //variablen samtidig, derfor må vi laas den. Laas maa da ogsaa vaere
      //static
      laas.lock();
      try{
        soknadsnr = soknadsnrGenerator++;
      }finally{
        laas.unlock();
      }
    }
  
    public int hentPrioritering(){
      return prioritering;
    }
  
    @Override
    public String toString(){
      return "Soknads nummer: " + soknadsnr + "\nNavn: " + navn + "\nPrioritering: " + prioritering;
    }
  
    //en static metode som gir deg et tall mellom 0-9 som er prioriteringen paa
    //en gitt soknad 
    public static int prioritering(boolean oslo, int alder, boolean rikeForeldre){
      int pri = 0;
      if(alder > 30){pri += 2;}
      if(alder > 35){pri += 2;}
      if(oslo){pri += 3;}
      if(rikeForeldre){pri += 2;}
      return pri;
    }
  }

class Boligsjef implements Runnable{

  Monitor monitor;
  String boligNavn;

  Boligsjef(Monitor monitor, String boligNavn){
    this.monitor = monitor;
    this.boligNavn = boligNavn;
  }

  @Override
  public void run(){
    Soknad soknad = monitor.hentUtSoknad();

    //henter ut soknader saa lenge det den henter ut ikke er null,
    //er det null er det ikke flere soknader igjen
    while(soknad != null){
      System.out.println(boligNavn + " har godtatt" + soknad + "\n----------------------------");
      try{
        Thread.sleep(5000);
      }catch(Exception e){
        System.out.println(e);
      }
      soknad = monitor.hentUtSoknad();
    }
  }
}