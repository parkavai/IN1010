class Person {

    private String navn, gjenstand;
    private Person neste;

    public Person(String navn, String gjenstand){
        this.navn = navn;
        this.gjenstand = gjenstand;
    }

    public Person hentNestePerson(){
        return this.neste;
    }

    public void settNeste(Person p){
        neste = p;
    }

    public String toString(){
        String helLinje = "";
        helLinje += navn + " kjøper " + gjenstand;
        return helLinje;
    }


}