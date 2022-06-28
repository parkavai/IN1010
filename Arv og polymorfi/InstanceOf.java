/*
Instance of
Den boolske operatoren "instance of" hjelper oss å finne ut av hvilken klasse et gitt objekt er, noe som 
er nyttig i mange tilfeller.

class TestFrukt {

    static void main(String[] args) {
        Eple e = new Eple();
        skrivUt(e);
    }

    static void skrivUt(Frukt f){

        if (f instanceof Eple){
            System.out.println("Dette er et eple");
        }
        else if (f instanceof Appelsin) {
            System.out.println("Dette er en appelsin");
        }

    }

}

Her vil vi sjekke om Eple "e" er en subklasse av superklassen Frukt. Og dette vil jo stemme da en Eple klasse 
vil arve egenskaper som superklassen Frukt har og den er en subklasse av Frukt. Dermed vil denne if-sjekken si at denne 
er sann. For at den andre if-sjekken skal kjøre, må metoden ta inn en instans av subklassen Appelsin. Dermed vil 
if-sjekken se om Appelsin er en instans av Frukt, noe den også er og vil dermed skrive ut sin melding. 


*/