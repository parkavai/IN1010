public abstract class Dyr {
    protected int alder;
    protected static int teller=0;
    public Dyr(){
        System.out.println("konstruerte dyr");
    }
    public void spisMat(){
        System.out.println("Jeg spiser mat!");
    }
    public int hashCode(){
        return 43;

    }
}