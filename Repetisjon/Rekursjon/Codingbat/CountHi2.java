public class CountHi2 {

    public static void main(String[] args) {
        
    }

    public int countHi2(String str) {
        if(str.length() < 2){
            return 0;
        }
        else if(str.length() == 2){
            if(str.equals("hi")){
            return 1 + countHi2(str.substring(2));
            }
            return 0;
        }
        else if(str.charAt(0) == 'x'){
            if(str.substring(0,3).equals("xhi")){
            return countHi2(str.substring(3));
            }
            return countHi2(str.substring(1));
        }
        else if(str.substring(0,2).equals("hi")){
            return 1 + countHi2(str.substring(2));
        }
        else {
            return countHi2(str.substring(1));
        }
    }
    
}
