import java.awt.Graphics;

public class Ball {
    double x = 0;
    double y = 0;

    double fx = 0;
    double fy = 0;
    double g = 1;
    int w = 10;
    int h = 10;

    public void update(double d){
        x = x + fx * d;
        y = y + fy * d;

        fy = fy + g;
        
        if(y > 420){
            fy = -fy;
        } 
    }

    public void display(Graphics g){
        g.drawOval((int)x, (int)y, w, h);
    }
}
