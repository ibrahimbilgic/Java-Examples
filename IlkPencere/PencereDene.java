package IlkPencere;

import javax.swing.JFrame;

public class PencereDene {
    public static void main(String[] args) {
        /*BizimPencere pencere = new BizimPencere();
        pencere.setSize(640,480);
        pencere.setVisible(true);*/

        //KarePencere kPencere = new KarePencere();
        /*kPencere.setSize(640,480);
        kPencere.setVisible(true);*/

        /*KarePencere panel1 = new KarePencere();
        JFrame pencere = new JFrame("Deneme");
        
        pencere.add(panel1);
        pencere.addKeyListener(panel1);
        pencere.setSize(640,480);
        pencere.setVisible(true);*/

        JFrame pencere = new JFrame();
        YeniPanel panel = new YeniPanel();
        pencere.add(panel);
        pencere.addKeyListener(panel);
        pencere.setSize(640,480);
        pencere.setVisible(true);
        
        
        
    }
    
}
