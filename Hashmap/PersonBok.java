import java.util.*;
public class PersonBok {

    public static void main(String[] args) {
        
        Person p1 = new Person("Parka", "14213131", "Gangstuveien 12");
        Person p2 = new Person("Parka", "64353431", "Nordlisletta 2B");
        Person p3 = new Person("Jimmy", "89610421", "Akerlia 131");
    /*
        Person[] liste = new Person[10];
        liste[0] = p1;
        liste[1] = p2;
        liste[2] = p3;

        for (Person p: liste) {
            if(p != null) {
                p.skrivInfo();
            }
        }
    */  
    
    /*
        ArrayList<Person> personListe = new ArrayList<Person>();
        personListe.add(p1);
        personListe.add(p2);
        personListe.add(p3);

        for(Person p: personListe){
            if(p != null) {
                p.skrivInfo();
            }
        }
    */ 

        HashMap<String, Person> personBok = new HashMap<>();

        personBok.put(p1.hentNavn(), p1);
        personBok.put(p2.hentNavn(), p2);
        personBok.put(p3.hentNavn(), p3);
        ArrayList<String> navneListe = new ArrayList<>();
        int teller = 0;

        for(Person p: personBok.values()){
            p.skrivInfo();
            navneListe.add(p.hentNavn());
        }

        for (int i = 0; i < navneListe.size(); i++) {
            for(int j = 1; j < navneListe.size(); j++) {
                if (navneListe.get(i).equals(navneListe.get(j))){
                    teller ++;
                    System.out.println(teller);
                }
            }
        }

    }
    
}
