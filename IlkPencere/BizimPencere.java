package IlkPencere;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.event.MouseInputListener;

public class BizimPencere extends JFrame implements MouseInputListener,KeyListener{
    private Random rn;
    private int x1,y1,x2,y2;
    private String yazi;

    public BizimPencere(){
        super();
        rn = new Random();
        addMouseListener(this);
        addKeyListener(this);

        x1 = 0;
        x2 = 0;
        y1 = 0;
        y2 = 0;
        
        yazi = "Merhaba Dünya";
    }

    @Override
    public void paint(Graphics g) {
        // TODO Auto-generated method stub
        super.paint(g);
        
        /*g.drawRect(160, 120, 320, 240);
        g.drawRect(320, 240, 160, 240);
        g.drawLine(0, 0, 200, 300);*/

        /*for(int i =0;i<100;i++){
            g.drawLine(rn.nextInt(640), rn.nextInt(480), rn.nextInt(640), rn.nextInt(480));
        }*/
        
        g.drawLine(x1, y1, x2, y2);
        g.drawString(yazi, x1, y1);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        if(e.getButton() == e.BUTTON1){
            x1 = e.getX();
            y1 = e.getY();
        }
        else if(e.getButton() == e.BUTTON3){
            x2 = e.getX();
            y2 = e.getY();
        }
        repaint();
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
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
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
        // TODO Auto-generated method stub
        if(e.getKeyCode() == e.VK_BACK_SPACE && yazi.length() > 0){
            yazi = yazi.substring(0,yazi.length()-1);
        }
        else{
            yazi = yazi + e.getKeyChar();
        }
        
        
        repaint();
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
