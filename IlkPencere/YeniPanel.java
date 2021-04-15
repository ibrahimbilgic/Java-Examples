package IlkPencere;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class YeniPanel extends JPanel implements KeyListener{

    Dortgen a;
    Dortgen[] digerleri;
    int adim = 5;
    int elemanSayisi = 5;


    public YeniPanel(){
        super();
        addKeyListener(this);
        a=new Dortgen(300, 200, 20, 20);
        digerleri = new Dortgen[10];
        digerleri[0] = new Dortgen(10,10,20,20);
        digerleri[1] = new Dortgen(50,40,20,20);
        digerleri[2] = new Dortgen(220,30,20,20);
        digerleri[3] = new Dortgen(60,30,20,20);
        digerleri[4] = new Dortgen(110,120,20,20);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        //g.drawRect(0, 0, 620, 460);
        
        a.ekranaCiz(g);
        for(int i=0; i<elemanSayisi; i++){
            digerleri[i].ekranaCiz(g);
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == e.VK_UP)
        {
            a.hareketEt(0, -adim,digerleri,elemanSayisi);
            repaint();

        }
        else if(e.getKeyCode() == e.VK_DOWN)
        {
            a.hareketEt(0, adim,digerleri,elemanSayisi);
            repaint();

        }
        else if(e.getKeyCode() == e.VK_RIGHT)
        {
            a.hareketEt(adim, 0,digerleri,elemanSayisi);
            repaint();

        }
        else if(e.getKeyCode() == e.VK_LEFT)
        {  
            a.hareketEt(-adim, 0,digerleri,elemanSayisi);
            repaint();

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
