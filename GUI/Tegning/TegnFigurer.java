import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TegnFigurer {
    public static void main(String[] args) throws FileNotFoundException{
        JFrame vindu = new JFrame("Tittel");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        File fil = new File("figurer.txt");
        FigurBrett brett = new FigurBrett(fil);
        JPanel panel = new JPanel();
        panel.add(brett);
        vindu.add(panel);
        vindu.pack();
        vindu.setVisible(true);
    }
}

class FigurBrett extends JPanel {
    Scanner lesFil;
    ArrayList<Figur> figurer = new ArrayList<>();
    FigurBrett(File fil) throws FileNotFoundException{
        lesFil = new Scanner(fil);
        lesInnFil(lesFil);
        leggTilIPanel();
    }

    void leggTilIPanel(){
        for(Figur f: figurer){
            add(f);
        }
    }

    void lesInnFil(Scanner lesFil){
        String type = "";
        while(lesFil.hasNextLine()){
            String linje = lesFil.nextLine();
            if(linje.equals("# Rectangles") || linje.equals("# Circles")){
                type = linje;
            }
            else if(type.equals("# Rectangles")){
                String[] data = linje.split(" ");
                String farge = "Sort";
                for(int i = 0; i < data.length; i++){
                    if(i > 4){
                        farge = data[4];
                    }
                    int x = Integer.parseInt(data[0]);
                    int y = Integer.parseInt(data[1]);
                    int bredde = Integer.parseInt(data[2]);
                    int hoyde = Integer.parseInt(data[3]);
                    Figur rektangel = new Rektangel(x, y, bredde, hoyde, farge);
                    figurer.add(rektangel);
                }
            }
            else {
                String[] data = linje.split(" ");
                String farge = "Sort";
                for(int i = 0; i < data.length; i++){
                    if(i > 3){
                        farge = data[3];
                    }
                    int x = Integer.parseInt(data[0]);
                    int y = Integer.parseInt(data[1]);
                    int radius = Integer.parseInt(data[2]);
                    Figur sirkel = new Sirkel(x, y, radius, farge);
                    figurer.add(sirkel);
                }
            }

        }
    }    
}

abstract class Figur extends JComponent{
    int x, y;
    String farge;

    Figur(int x, int y, String farge){
        this.x = x;
        this.y = y;
        this.farge = farge;
    }

    abstract void tegn(Graphics2D g2);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void settFarge(Graphics g2){
        if(farge.equals("Sort")){
            g2.setColor(Color.BLACK);
        }
        else if(farge.equals("RED")){
            g2.setColor(Color.RED);
        }
        else {
            g2.setColor(Color.BLUE);
        }
    }
}

class Rektangel extends Figur{
    int x, y, hoyde,bredde;
    String farge;

    Rektangel(int x, int y, int bredde, int hoyde, String farge){
        super(x,y,farge);
        this.bredde = bredde;
        this.hoyde = hoyde;
        setPreferredSize(new Dimension(x, y));
    }

    @Override
    public void tegn(Graphics2D g2){
        settFarge(g2);
        g2.fillRect(x, y, bredde, hoyde);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        tegn(g2);
    }

}

class Sirkel extends Figur{
    int x, y, radius;
    String farge;

    Sirkel(int x, int y, int radius, String farge){
        super(x,y,farge);
        this.radius = radius;
        setPreferredSize(new Dimension(x, y));
    }

    @Override
    public void tegn(Graphics2D g2){
        settFarge(g2);
        g2.fillOval(x, y, radius, radius);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        tegn(g2);
    }
}