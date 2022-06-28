interface Sterk{
    int vekt = 2;
    
    int hentStyrke(int styrke);
}

class Person implements Sterk{
    int alder;
    String navn;

    Person(int alder, String navn){
        this.alder = alder;
        this.navn = navn;
    }

    int hentAlder(){
        return this.alder;
    }

    public String hentNavn(){
        return this.navn;
    }

    public String toString(){
        return "Navn: " + this.navn + "\n" + "Alder: " + this.alder + "\n";
    }

    @Override
    public int hentStyrke(int styrke){
        return styrke;
    }
}

class Student extends Person{

    String studentId;

    Student(int alder, String navn, String studentId){
        super(alder, navn);
        this.studentId = studentId;
    }

    String hentId(){
        return this.studentId;
    }

    @Override
    public String hentNavn(){
        return "sadada" + studentId;
    }

    @Override
    public String toString(){
        return "Navn: " + this.navn + "\n" + "Alder: " + this.alder + "\n" + "Student-id: " + this.studentId + "\n";
    }
}

class testPekere{
    public static void main(String[] args) {
        Person pers = new Person(5, "Parka");
        Student stud = new Student(8, "Rcsan", "Rcsan-1");
        Person persen = new Student(8, "Kangy", "Kangy-1");
        Sterk test = persen;
        Sterk test2 = pers;
        System.out.println(persen.hentId());
        /*
        System.out.println(persen.toString());
        System.out.println(persen.hentNavn());
        System.out.println(stud.toString());
        */
        System.out.println(persen.hentStyrke(222));
        System.out.println(test.hentStyrke(132));
        System.out.println(test2.hentStyrke(222));
    }
}