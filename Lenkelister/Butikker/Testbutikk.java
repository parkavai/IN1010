class Testbutikk {

    public static void main(String[] args) {
        Butikk butikken = new Butikk();
        /*
        Person p1 = new Person("Stig", "Sitronsaft");
        Person p2 = new Person("Hedda", "Engangskopper");
        Person p3 = new Person("Jawad", "Pasta");
        Person p4 = new Person("Henrik", "Kaffe");
        Person p5 = new Person("Mathias", "Tomatsuppe");
        butikken.entreButikk(p1);
        butikken.entreButikk(p2);
        butikken.entreButikk(p3);
        butikken.entreButikk(p4);
        butikken.entreButikk(p5);
        */
        butikken.entreButikk(new Person("Stig", "Sitronsaft"));
        butikken.entreButikk(new Person("Hedda", "Engangskopper"));
        butikken.entreButikk(new Person("Jawad", "Pasta"));
        butikken.entreButikk(new Person("Henrik", "Kaffe"));
        butikken.entreButikk(new Person("Mathias", "Tomatsuppe"));
        // butikken.gaaTilKassen();
        System.out.println("BUTIKK-KØ: ");
        for(Person p : butikken){
            if(p == null){
                System.out.println("Tom for kunder!");
                return;
            }
            System.out.println(p);
            System.out.println("- Hade bra!" + "\n");
        }
    }
    
}
