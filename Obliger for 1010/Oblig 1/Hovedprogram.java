import java.io.*;
public class Hovedprogram{
    public static void main(String[] args) {
    /*
        Dataklynge dataklynge = new Dataklynge(12); // Skriv inn antNoderPerRack i konstruktøren til dataklynge
        Rack rack = new Rack();
        int konstant = 1;
        for(int i = 0; i < 650; i++){
            if(i == 12*konstant){
                dataklynge.leggTilRack(rack);
                konstant++;
                rack = new Rack();
            }
            rack.leggTilNode(new Node(64, 1));
        }
        Rack nyRack = new Rack();
        for(int i = 0; i < 16; i++){
            if(i == 12*konstant){
                dataklynge.leggTilRack(nyRack);
                konstant++;
                nyRack = new Rack();
            }
            nyRack.leggTilNode(new Node(1024, 2));
        }
        System.out.println(dataklynge.toString());
    */

    Dataklynge dataklynge = new Dataklynge(new File("dataklynge.txt"));
    System.out.println(dataklynge.toString());
    }
}