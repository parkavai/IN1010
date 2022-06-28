public class KaninOerer {


    public static void main(String[] args) {
        System.out.println(bunnyEars2(2));
    }
    static int bunnyEars2(int bunnies) {
        int tall = bunnies % 2;
        if(bunnies == 0){
            return 0;
        }
        else if(tall == 1){
            return 2 + bunnyEars2(bunnies-1);
        }
        else {
            return 3 + bunnyEars2(bunnies-1);
        }
  }
    
}
