import java.io.File;
import java.io.FileNotFoundException;
import java.io.*;

public class TestLabyrint {

    public static void main(String[] args) throws FileNotFoundException{
        File filnavn = new File("7.in");
        Labyrint lab = new Labyrint(filnavn);
        lab.finnUtveiFra(1,1);
        lab.hentKortesteUtvei();
    }
    
}
