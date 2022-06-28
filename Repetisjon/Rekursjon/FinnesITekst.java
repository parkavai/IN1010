public class FinnesITekst {
    public static void main(String[] args) {
        System.out.println(finnesitekst("abc", 'c'));
    }

    static boolean finnesitekst(String streng, char bokstav){
        if (streng.equals("") || streng == null){
            System.out.println("Fant ingen forekomster av bokstaven: " + bokstav);
            return false;
        }
        if(streng.charAt(0) == bokstav){
            System.out.println("Fant bokstaven: " + bokstav);
            return true;
        }
        return finnesitekst(streng.substring(1), bokstav);
    }
    
}

