package IlkPencere;
import java.awt.Graphics;
import java.awt.Rectangle;
public class Dortgen {
    Rectangle r; //javada dikdortgen classı 
    
    public Dortgen(int x,int y,int width,int height) {
        r = new Rectangle(x,y,width,height);
    }   
    
    
    public void ekranaCiz(Graphics g){
        g.drawRect((int)r.getX(), (int)r.getY(), (int)r.getWidth(),(int) r.getHeight()); //drawRect int değerler alıyor.
        
    }
    public void hareketEt(int x,int y,Dortgen[] digerleri,int sayi){
        Rectangle gecici = new Rectangle(r);
        gecici.setLocation((int)gecici.getX()+x,(int)gecici.getY()+y);

        boolean cakisma = false;

        for(int i=0; i<sayi;i++)
        {
            if(gecici.intersects(digerleri[i].getRectangle()))
            {
                cakisma = true;
            }
        }

        if(gecici.getX()<0 || gecici.getY()<0 || gecici.getX()>640-gecici.getWidth() || gecici.getY()>480-gecici.getHeight()){
            cakisma  = true;
        }

        if(cakisma == false)
        {
            r.setLocation((int)r.getX()+x,(int)r.getY()+y);
        }
        
    }
    public Rectangle getRectangle(){
        return r;
    }

    
}
