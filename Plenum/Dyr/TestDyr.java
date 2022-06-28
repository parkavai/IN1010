public class TestDyr {

    public static void main(String[] args) {

        Dyr dyr = new Pattedyr();
        dyr.spisMat();

        Pattedyr hund = new Hund();

        if(hund instanceof Pattedyr){
            System.out.print(true);
        }





    }
    
}
