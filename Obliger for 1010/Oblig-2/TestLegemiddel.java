public class TestLegemiddel{


    public static void main(String[] args) {

        Narkotisk n1 = new Narkotisk("Barbital", 100, 40.3, 10);
        Vanedannende v1 = new Vanedannende("Nesespray", 90, 50.5, 7);
        Vanlig vn1 = new Vanlig("Vi-siblin", 70, 10);

        System.out.print("Tester for Narkotisk legemiddel: \n" );
        narkotiskObjekt(n1);
        System.out.println("");

        System.out.print("Tester for Vanedannende legemiddel: \n");
        vanedannendeObjekt(v1);
        System.out.println("");

        System.out.print("Tester for Vanlig legemiddel: \n");
        vanligObjekt(vn1);
        System.out.println("");
        
        
        System.out.println(testLegemiddelId(n1, 1));

        System.out.println("");
        System.out.println(n1.toString());

        System.out.println("");
        System.out.println(v1.toString());

        System.out.println("");
        System.out.println(vn1.toString());
        

        
    }

    public static boolean testLegemiddelId(Legemiddel legemiddel, int forventetLegemiddelId) {
        return legemiddel.hentId() == forventetLegemiddelId;
    }

    public static void vanligObjekt(Vanlig objekt) {

        if (objekt.hentNavn() == "Vi-siblin") {
            System.out.println("Riktig 1");
        }
        else {
            System.out.println("Feil 1");
        }

        if (objekt.hentPris() == 70) {
            System.out.println("Riktig 2");
        }
        else {
            System.out.println("Feil 2");
        }


        objekt.settNyPris(200);

        if (objekt.hentPris() == 200) {
            System.out.println("Riktig 3");
        }
        else {
            System.out.println("Feil 3");
        }

        if (objekt.hentVirkestoff() == 10) {
            System.out.println("Riktig 4");
        }
        else {
            System.out.println("Feil 4");
        }

    }

    public static void vanedannendeObjekt(Vanedannende objekt) {
      
        if (objekt.hentNavn() == "Nesespray") {
            System.out.println("Riktig 1");
        }
        else {
            System.out.println("Feil 1");
        }


        if (objekt.hentVanedannendeStyrke() == 7) {
            System.out.println("Riktig 2");
        }
        else {
            System.out.println("Feil 2");
        }

    }

    public static void narkotiskObjekt(Narkotisk objekt) {

        if (objekt.hentNarkotiskStyrke() == 10) {
            System.out.println("Riktig 1");
        }
        else {
            System.out.println("Feil 1");
        }

    }


}
