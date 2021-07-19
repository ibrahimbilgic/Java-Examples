import java.awt.Graphics;

public class Ball {
    double x = 0;
    double y = 0;

    double fx = 0;
    double fy = 0;
    double g = 0.5;
    int w = 10;
    int h = 10;

    public void update(double d){ 
        x = x + fx * d;
        y = y + fy * d;

        
        
        if(y > 480-w){
            y = 480-w;
            fy = -fy;
        } 
        else{
            fy = fy + g * d;
        }
        if(x>640-w){
            x = 640 - w;
            fx = -fx;
        }
        else if(x<0){
            x = 0;
            fx = -fx;
        }
    }

    public void display(Graphics g){
        g.drawOval((int)x, (int)y, w, h);
    }
}
