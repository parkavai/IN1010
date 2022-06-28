import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Random;

class Minesveiper {
    static final int N_KOL = 10, N_RAD = 8;
    static final double andelMiner = 0.10;

    static boolean harVunnet = false, harTapt = false;
    static Rute[][] ruter = new Rute[N_KOL][N_RAD];
    static JLabel info = new JLabel("   "); 

    public static void main (String[] args) {
        JFrame vindu = new JFrame("Minesveiper");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel spill = new JPanel();
        vindu.add(spill);

        JPanel rutenett = new JPanel();
        rutenett.setLayout(new GridLayout(N_RAD,N_KOL));

        for (int rx = N_RAD-1;  rx >= 0;  rx--) {
            for (int kx = 0;  kx < N_KOL;  kx++) {
                Rute a = new Rute(kx,rx);
                a.initGUI();
                ruter[kx][rx] = a;
                rutenett.add(a);
            }
        }
        spill.add(rutenett);

        spill.add(info);

        JButton stoppknapp = new JButton("Exit");
        class Stopper implements ActionListener {
            public void actionPerformed (ActionEvent e) {
                System.exit(0);
            }
        }
        stoppknapp.addActionListener(new Stopper());
        spill.add(stoppknapp);

        vindu.pack();
        vindu.setVisible(true);
    }

    static void sjekkOmVunnet () {
        // Vi har vunnet om alle uaapnete ruter inneholder en mine.

        boolean vunnet = true;
        for (int rx = 0;  rx < N_RAD;  rx++) {
            for (int kx = 0;  kx < N_KOL;  kx++) {
                Rute a = ruter[kx][rx];
                if (! a.aapnet && ! a.harMine) vunnet = false;
            }
        }
        if (vunnet) {
            harVunnet = true;
            info.setText("Du har vunnet");
        }
    }
}

class Rute extends JButton implements ActionListener {
    static Random tilfeldig = new Random();

    int kol, rad;
    boolean harMine;
    boolean aapnet = false;

    Rute (int k, int r) {
        kol = k;  rad = r;
        harMine = tilfeldig.nextDouble()<Minesveiper.andelMiner;
    }

    @Override
    public void actionPerformed (ActionEvent e) {
        if (aapnet || Minesveiper.harVunnet || Minesveiper.harTapt) return;

        if (harMine) {
            setForeground(Color.RED);
            setText("O");
            Minesveiper.info.setText("Du har tapt");
            Minesveiper.harTapt = true;
        } else {
            setText("" + antNabominer());
            aapnet = true;
            Minesveiper.sjekkOmVunnet();
        }
    }

    void initGUI () {
        setPreferredSize(new Dimension(30,30));
        addActionListener(this);
    }

    int antNabominer () {
        int n = 0;
        if (finnesMine(kol-1,rad-1)) n++;
        if (finnesMine(kol-1,rad)) n++;
        if (finnesMine(kol-1,rad+1)) n++;
        if (finnesMine(kol,rad-1)) n++;
        if (finnesMine(kol,rad+1)) n++;
        if (finnesMine(kol+1,rad-1)) n++;
        if (finnesMine(kol+1,rad)) n++;
        if (finnesMine(kol+1,rad+1)) n++;
        return n;
    }

    boolean finnesMine (int k, int r) {
        return k>=0 && k<Minesveiper.N_KOL && r>=0 && r<Minesveiper.N_RAD &&
            Minesveiper.ruter[k][r].harMine;
    }
}