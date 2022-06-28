public class TestResept{


    public static void main(String[] args) {

        Vanlig lm1 = new Vanlig ("Vi-sibling", 120, 20);
        Lege l1 = new Lege ("Espen");
        HvitResept h1 = new HvitResept (lm1, l1, 4, 3);

        Vanedannende lm2 = new Vanedannende ("Diprosalic", 100, 30, 2);
        Lege l2 = new Lege ("Karl");
        BlaaResept b1 = new BlaaResept (lm2, l2, 3,2);

        Vanlig lm4 = new Vanlig ("Lactosylid", 109, 30);
        Lege l4 = new Lege ("Jim");
        Presept p1 = new Presept (lm4, l4, 5);

        Narkotisk nm1 = new Narkotisk ("Nasonex", 20, 20, 40);
        Spesialister s3 = new Spesialister ("Jake", "1312313");
        MilitaerResept m2 = new MilitaerResept (nm1, s3, 2,2);

        Narkotisk lm3 = new Narkotisk ("Fungoral", 100, 30, 10);
        Lege l3 = new Lege ("Roy");
        MilitaerResept m1 = new MilitaerResept (lm3, l3, 2,2);

        System.out.println(h1.toString());
        System.out.println("Test over hvit-resept: ");
        hvitReseptObjekt(h1);
        System.out.println("");


        System.out.println(b1.toString());
        System.out.println("Test over blå-resept: ");
        blaaReseptObjekt(b1);
        System.out.println("");

        System.out.println(m1.toString());
        System.out.println("Test over militær-resept: ");
        MilitaerReseptObjekt(m1);
        System.out.println("");

        System.out.println(p1.toString());
        System.out.println("Test over p-resept: ");
        PReseptObjekt(p1);
        System.out.println("");

        System.out.println(m2.toString());
        System.out.println("Test over militær-resept med spesialist: ");
        MilitaerReseptObjekt(m2);
        System.out.println("");




    }

    public static void hvitReseptObjekt(HvitResept objekt) {

        objekt.bruk();
        objekt.bruk();

        if (objekt.farge() == "Hvit") {
            System.out.println("Riktig 1");

        }

        else {
            System.out.println("Feil 1");
        }

        if (objekt.prisAaBetale() == 120) {
            System.out.println("Riktig 2");
        }

        else {
            System.out.println("Feil 2");
        }

        if (objekt.hentReit() == 1) {
            System.out.println("Riktig 3");
        }
        else {
            System.out.println("Feil 3");
        }

        objekt.bruk();

        if (objekt.hentReit() == 0) {
            System.out.println("Riktig 4");
        }
        else {
            System.out.println("Feil 4");
        }

        if (objekt.hentPasientId() == 4) {
            System.out.println("Riktig 5");
        }
        else {
            System.out.println("Feil 5");
        }


    }

    public static void blaaReseptObjekt(BlaaResept objekt) {

        if (objekt.farge() == "Blå") {
            System.out.println("Riktig 1");

        }

        else {
            System.out.println("Feil 1");
        }

        if (objekt.prisAaBetale() == 25) {
            System.out.println("Riktig 2");
        }

        else {
            System.out.println("Feil 2");
        }

    }

    public static void MilitaerReseptObjekt(MilitaerResept objekt) {

        if (objekt.farge() == "Hvit") {
            System.out.println("Riktig 1");

        }

        else {
            System.out.println("Feil 1");
        }

        if (objekt.prisAaBetale() == 0) {
            System.out.println("Riktig 2");
        }

        else {
            System.out.println("Feil 2");
        }

    }

    
    public static void PReseptObjekt(Presept objekt) {

        if (objekt.farge() == "Hvit") {
            System.out.println("Riktig 1");

        }

        else {
            System.out.println("Feil 1");
        }

        if (objekt.prisAaBetale() == 1) {
            System.out.println("Riktig 2");
        }

        else {
            System.out.println("Feil 2");
        }

    }




}
