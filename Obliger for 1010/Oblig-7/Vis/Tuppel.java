
public class Tuppel {
    private int x, y;

    public Tuppel(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int hentXKoordinat(){
        return x;
    }

    public int hentYKoordinat(){
        return y;
    }

    public String toString(){
        String helLinje = "( " + x + ", " + y + ")";
        return helLinje;
    }
    
}
