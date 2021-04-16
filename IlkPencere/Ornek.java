package IlkPencere;

import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class Ornek extends JFrame implements MouseInputListener{

    JLabel label1,label2;
    JPanel panel1;

    int sayi = 0;
    Ornek(){
        super();

        panel1  = new JPanel();
    
        label1 = new JLabel("Hoş geldiniz");
        panel1.add(label1);

        label2  = new JLabel(""+sayi); //boş string + int yazarsak java hepsini string yapacaktır.
        panel1.add(label2);

        add(panel1); //label1 ve label2 yanyana dizilmiş olacak.
        addMouseListener(this);
    }
    public static void main(String[] args) {
        Ornek pencere = new Ornek();
        pencere.setSize(640,480);
        pencere.setVisible(true);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == e.BUTTON1){
            sayi++;
        }
        else if(e.getButton() == e.BUTTON3){
            sayi--;
        }
        label2.setText(""+sayi);
        
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

}
