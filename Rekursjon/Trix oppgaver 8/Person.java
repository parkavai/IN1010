class Person implements Comparable<Person>{
    int fodsel;
    String navn;
    Person mor;
    Person far;

    Person(int fodsel, String navn, Person mor, Person far) {
        this.fodsel = fodsel;
        this.navn = navn;
        this.mor = mor;
        this.far = far;
    }

    public String hentNavn() {
        return navn;
    }

    public int hentFodsel() {
        return fodsel;
    }

    public Person hentMor() {
        return mor;
    }

    public Person hentFar() {
        return far;
    }

    public String toString(){
        String helLinje = " \n";
        helLinje += "Navn: " + navn;
        helLinje += "Fødsel: " + fodsel;
        helLinje += "Mor: " + mor;
        helLinje += "Far: " + far;
        return helLinje;
    }

    public int compareTo(Person nyPerson) {
        int verdi = 0;
        // nyPerson er eldst
        if(this.fodsel < nyPerson.fodsel){
            verdi = -1;
        }
        // Denne personen er eldst
        if (this.fodsel > nyPerson.fodsel){
            verdi = 1;
        }
        // Begge er like gamle
        if(this.fodsel == nyPerson.fodsel){
            verdi = 0;
        }
        return verdi;
    }

    public Person finnEldsteKjenteForfader(){
        if(mor == null){
          if(far == null)
            return this;
          else
            return far.finnEldsteKjenteForfader();
        }
        if(far == null){
          return mor.finnEldsteKjenteForfader();
        }
    
        Person morside = mor.finnEldsteKjenteForfader();
        Person farside = far.finnEldsteKjenteForfader();
    
        if(morside.compareTo(farside) < 0) {
          return morside;
        }

        else {
          return farside;
        }
      }




    
}
