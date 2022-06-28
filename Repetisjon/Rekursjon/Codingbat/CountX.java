public class CountX {

    public static void main(String[] args) {
        System.out.println(countX("xxhixx"));
    }

    static int countX(String str){
        if(str.equals("")){
            return 0;
        }
        else if(str.charAt(str.length()-1) == 'x'){
            return 1 + countX(str.substring(0, str.length()-1));
        }
        else {
            return countX(str.substring(0, str.length()-1));
        }
    }
    
}