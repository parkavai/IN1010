public class Integrasjonstest {

    public static void main(String[] args) {

        Vanlig ibux = new Vanlig ("Ibux", 41, 2.0);
        Lege dinLege = new Lege ("Mai Berg");
        BlaaResept ibuxResept = new BlaaResept (ibux, dinLege, 0,4);

        Narkotisk paracept = new Narkotisk ("Paracet", 50, 1.5, 15);
        Spesialister dinLege2 = new Spesialister ("James", "13321");
        MilitaerResept paraceptResept = new MilitaerResept (paracept, dinLege2, 1,3);

        Vanedannende nesespray = new Vanedannende ("Nesespray", 100, 5.0, 10);
        Lege dinLege3 = new Lege ("Karl");
        HvitResept nesesprayResept = new HvitResept (nesespray, dinLege3, 2, 3);

        Vanlig fungoral = new Vanlig ("Fungoral", 100, 3.0);
        Lege dinLege4 = new Lege ("Mason");
        Presept fungoralResept = new Presept (fungoral, dinLege4, 3);

        System.out.println(ibuxResept.toString());

        System.out.println(paraceptResept.toString());

        System.out.println(nesesprayResept.toString());

        System.out.println(fungoralResept.toString());

    }
    
}
