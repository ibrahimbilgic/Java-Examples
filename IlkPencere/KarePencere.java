package IlkPencere;

import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.event.MouseInputListener;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class KarePencere extends JPanel implements ActionListener,MouseInputListener,KeyListener{
    //Panellerde paint yerine paintCompanent override edilmeli 
    
    int artis = 2;

    Cember[] cembers;
    int cemberCount=0;
    int cemberEleman = 0;
    int cemberMax = 10;

    Timer zaman;
    
    public KarePencere(){
        super();
        
        addMouseListener(this);
        //addKeyListener(this);

        cembers = new Cember[cemberMax];

        zaman = new Timer(40,this);
        zaman.start();
    }
    public void paintCompanent(Graphics g){
        super.paintComponent(g);

        for(int i = 0; i < cemberEleman; i++){
            cembers[i].ekranaCiz(g);
        }

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < cemberEleman; i++){
            cembers[i].genisle(artis);
        }
        
        repaint();
        
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        Cember yeniCember = new Cember(e.getX(),e.getY(),0);

        cembers[cemberCount] = yeniCember;
        cemberCount  = (cemberCount +1) % cemberMax;
        
        if(cemberEleman < cemberMax){
            cemberEleman += 1;
        }
        
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        zaman.start();
        
    }
    @Override
    public void mouseExited(MouseEvent e) {
        zaman.stop();
        
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
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == e.VK_UP){
            artis++;
        }
        else if(e.getKeyCode() == e.VK_DOWN){
            artis--;
        }
        
    }
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

}
