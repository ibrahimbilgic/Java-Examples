import java.awt.Graphics;

public class Ball extends PhysicForGame{
   
    public Ball(double x, double y, double vx, double vy, double w, double h, double m) {
        super(x, y, vx, vy, w, h, m);
    }


    @Override
    public void display(Graphics g) {
        g.drawOval((int)x, (int)y, (int)w, (int)h);
    }
        
}

