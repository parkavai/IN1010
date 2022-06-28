public class MinstTallArray {
    public static void main(String[] args) {
        int[] liste = {1,2,5,4,3,6,10};
        System.out.println(finnMinste(0, liste));
    }


    static int finnMinste(int indeks, int[] tallArray) {
        if (indeks == tallArray.length -1) {  //basissteget: hvis index er siste index i array
            return tallArray[indeks];
        }
        int returnert = finnMinste(indeks+1, tallArray);  //minste tallet av de resterende i array
        if (returnert < tallArray[indeks]) {
            return returnert;
        } else {
            return tallArray[indeks];
        }
    }
    
}
