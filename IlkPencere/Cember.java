package IlkPencere;
import java.awt.Graphics;

public class Cember {
    int x,y;
    int gen;

    public Cember(int x, int y, int gen) {
        this.x = x;
        this.y = y;
        this.gen = gen;
    }

    public void ekranaCiz(Graphics g){
        g.drawOval(x, y, gen, gen);
    }

    public void genisle(int a){
        gen += a;
        x =  x - a/2;
        y = y - a/2;
        
    }

  
}
