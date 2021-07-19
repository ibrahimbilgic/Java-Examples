import java.awt.Graphics;
public abstract class PhysicForGame {
    
    double x = 0;
    double y = 0;
    double vx = 0;
    double vy = 0;

    double w = 0;
    double h = 0;
    
    double m = 0;

    public PhysicForGame(double x, double y, double vx, double vy, double w, double h, double m) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.w = w;
        this.h = h;
        this.m = m;
    }

    public abstract void display(Graphics g);

}
