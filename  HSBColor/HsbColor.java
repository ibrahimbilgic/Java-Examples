import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;


public class HsbColor extends JPanel implements MouseInputListener{
    
    BufferedImage image;
    int sizeX = 590;
    int sizeY = 400;
    String text = "";
    Color color;

    public HsbColor(){
        image = new BufferedImage(sizeX,sizeY,BufferedImage.TYPE_INT_RGB);
        resetImage();
    }
    private void resetImage() {

        float hue = 0F;
        float saturation = 0F;
        for(int i=0;i<sizeX;i++){
           for(int j=0;j<sizeY;j++){
            hue = (i + 0F) / sizeX;
            saturation = (j + 0F) / sizeY;
            color = Color.getHSBColor(hue, saturation, 1F);
            image.setRGB(i, j, color.getRGB());
        }
       }
    }
    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(image, 20,20, null);
        g.drawString(text, 10, 15);
    }

    public void changeColor(int x, int y){
        float hue = (x - 20F) / sizeX;
        float saturation = (y - 20F) / sizeY;
        color = Color.getHSBColor(hue, saturation, 1F);

        Graphics2D g = image.createGraphics();
        g.setColor(color);
        g.fillRect(0, 0, sizeX, sizeY);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            text = "X: "+e.getX() + " -Y:"+e.getY();
            changeColor(e.getX(), e.getY());
            repaint();
        }
        else if(e.getButton() == MouseEvent.BUTTON3){
            resetImage();
            repaint(); 
        }

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

   public static void main(String[] args) {
    JFrame frame = new JFrame("Colors");
    HsbColor panel = new HsbColor();
    panel.addMouseListener(panel);
    frame.add(panel);

    frame.setSize(640,480);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
   }
}