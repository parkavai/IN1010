public class StringCount {

    public static void main(String[] args) {
        System.out.println(strCount("catcowcat", "cat"));
        
    }

    static int strCount(String str, String sub) {
        if(str.length() == sub.length()){
            if(str.substring(0,str.length()).equals(sub)){
            return 1;
            }
            else {
            return 0;
            }
        }
        else if(str.substring(0,sub.length()).equals(sub)){
            return 1 + strCount(str.substring(sub.length()), sub);
        }
        else {
            return strCount(str.substring(1), sub);
        }
    }
    
}
