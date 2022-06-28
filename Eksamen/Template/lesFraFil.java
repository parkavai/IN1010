import java.util.io.*;
import java.util.FileNotFoundException;

public class lesFraFil{

    public static void main(String[] args) throws FileNotFoundException{

        Scanner lesInn;
        try {
            File fil = new File();
            lesInn = new Scanner(fil);
        }
        catch(FileNotFoundException e) {
            System.out.println("Fant ikke filen");
            System.exit(1);
        }

        while (lesInn.hasNext()){
            //
        }
    }
    
}
