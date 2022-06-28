public class Flytype {

    private String type, seteinfo;

    Flytype(String type, String seteinfo){
        this.type = type;
        this.seteinfo = seteinfo;
    }

    Flygning opprettFlygning() {
        Flygning flygning = new Flygning(type,seteinfo);
        return flygning;
    }
    
}
