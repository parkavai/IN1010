public class TestPerson{
  public static void main(String[] args) {
    Person p1 = new Person(1672, "Inga", null, null);
    Person p2 = new Person(1690, "Karsten", p1, null );
    Person p3 = new Person(1694, "Petra", null, null);
    Person p4 = new Person(1715, "Ole", p3, p2);
    Person p5 = new Person(1718, "Ingeborg", null, null);
    Person p6 = new Person(1738, "Knut", p5, p4);
    Person p7 = new Person(1715, "Kai", null, null);
    Person p8 = new Person(1740, "Kari", null, p7);
    Person p9 = new Person(1761, "Sigrid", p8, p6);

    System.out.println("Sigrids eldste forfader er " + p9.finnEldsteKjenteForfader());
    //Sigrids eldste forfader er Inga.
    System.out.println("Riktig? " + (p9.finnEldsteKjenteForfader() == p1));
    System.out.println();

    System.out.println("Karis eldste forfader er " + p8.finnEldsteKjenteForfader());
    //Karis eldste forfader er Kai.
    System.out.println("Riktig? " + (p8.finnEldsteKjenteForfader() == p7));
    System.out.println();

    System.out.println("Ingas eldste forfader er " + p1.finnEldsteKjenteForfader());
    //Ingas eldste forfader er Inga selv.
    System.out.println("Riktig? " + (p1.finnEldsteKjenteForfader() == p1));
    System.out.println();
  }
}

class Person implements Comparable<Person>{
    int fodsel;
    String navn;
    Person mor;
    Person far;

    Person(int fodsel, String navn, Person mor, Person far){
        this.fodsel = fodsel;
        this.navn = navn;
        this.mor = mor;
        this.far = far;
    }

    int hentFodsel(){
        return fodsel;
    }

    String hentNavn(){
        return navn;
    }

    Person hentMor(){
        return mor;
    }

    Person hentFar(){
        return far;
    }

    Person finnEldsteKjenteForfader(){
        if(this.mor == null && this.far == null){
            return this;
        }
        if (this.mor == null){
            return far.finnEldsteKjenteForfader();
        }
        if (this.far == null){
            return mor.finnEldsteKjenteForfader();
        }
        Person morside = mor.finnEldsteKjenteForfader();
        Person farside = far.finnEldsteKjenteForfader();
        if(morside.compareTo(farside) < 0){
            return morside;
        }
        else{
            return farside;
        }

    }

    @Override
    public int compareTo(Person peker){
        return this.hentFodsel()-peker.hentFodsel();
    }

    @Override
    public String toString(){
        String helLinje = "Navn: " + navn + "\n";
        helLinje += "Fodt i aar: " + fodsel + "\n";
        return helLinje;
    }

}
