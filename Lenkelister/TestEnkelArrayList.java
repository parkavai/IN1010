public class TestEnkelArrayList {

    public static void main(String[] args) {
        int lengde = 10;
        EnkelArrayList liste = new EnkelArrayList(lengde);

        for(int i = 0; i < lengde; i++){
            String streng =  " " + i;
            liste.leggTil(streng);
        }

        liste.skrivUt();
    }
    
}
