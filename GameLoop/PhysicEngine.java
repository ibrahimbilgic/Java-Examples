import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Graphics;

public class PhysicEngine {
    ArrayList<PhysicForGame> eForGames;
    double g = 0.3;
    double speedBorder = 0.001;

    public PhysicEngine() {
        eForGames = new ArrayList<>();
    }

    public void addElement(PhysicForGame element){
        eForGames.add(element);
    }

    public void display(Graphics g){
        Iterator<PhysicForGame> it = eForGames.iterator();
        while(it.hasNext()){
            PhysicForGame e = it.next();
            e.display(g);
        }
        //g.drawOval((int)x, (int)y, (int)w, (int)h);
    }

    public void update(double d){
        Iterator<PhysicForGame> it = eForGames.iterator();
        while(it.hasNext()){
            PhysicForGame e = it.next();

            e.x = e.x + e.vx * d;
            e.y = e.y + e.vy * d;
    
            e.vx = e.vx*0.999;
            e.vy = e.vy*0.999;
    
            if(e.y > 480-e.w){
                e.vy = e.vy - e.m * d * 0.2;
                e.y = 480-e.w;
                if(e.vy<speedBorder){
                    e.vy = 0;
                    e.vx = e.vx * 0.9;
                }
                else{
                    e.vy = e.vy - g * d;
                    e.vy = -e.vy;
                }
    
            } 
            else{
                e.vy = e.vy + g * d;
            }
    
            if(e.x>640-e.x){
                e.vx = e.vx - e.m * d * 0.2;
                if(e.vx<speedBorder){
                    e.vx = 0;
                }
                e.x = 640 - e.x;
                e.vx = -e.vx;
            }
            else if(e.x<0){
                e.vx = e.vx + e.m * d * 0.2;
                if(e.vx > -speedBorder){
                    e.vx = 0;
                }
                e.x = 0;
                e.vx = -e.vx;
            }
        }

    }

    
}
