import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class LecOne extends JFrame{
    private int wHeight = 640;
    private int wWidth = 480;
    private Insets ins;
    private int targetFPS = 60;
    private BufferedImage bufferedImage;
    private boolean isGameCont = true;

    private int x = 10;
    private int y = 10;
    private long fpsSysOut = 0;
    private int currentFps = 0;

    Ball[] ball = null;
    int ballNum = 10; 
    public static void main(String[] args) {
        LecOne game = new LecOne();
        game.loop();
        
    }


    private void loop() {
        start();
        long lastLoopTime = System.nanoTime();
        long targetLoopTime = 1000000000 / targetFPS;

        // Loop will start
        while(isGameCont){
            
            long currentLoopTime = System.nanoTime();
            long loopTime = currentLoopTime - lastLoopTime;
            
            lastLoopTime = currentLoopTime;

            double timeVar = (double)loopTime / (double)targetLoopTime; 

            currentFps++;
            fpsSysOut = fpsSysOut + loopTime;
            if(fpsSysOut >= 1000000000){
                System.out.println("fps: "+currentFps);
                fpsSysOut = 0;
                currentFps = 0;
            }
            //Update
            gameUpdate(timeVar);

            //Render
            gameGraphicUpdate();

            long extraNanoTime = targetLoopTime - (System.nanoTime() - currentLoopTime);
            try {
                if(extraNanoTime > 0){
                    Thread.sleep(extraNanoTime/1000000);
                }
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private void gameGraphicUpdate() {
        Graphics frameGraphics = getGraphics();

        Graphics bufferGraphics = bufferedImage.getGraphics();

        // buffer update
        bufferGraphics.setColor(Color.WHITE);
        bufferGraphics.fillRect(0, 0, wHeight, wWidth);

        bufferGraphics.setColor(Color.BLACK);
        for(int i=0;i<ballNum;i++){
            ball[i].display(bufferGraphics); 
        }
        

        //Buffer -> Frame -> Paint
        frameGraphics.drawImage(bufferedImage,ins.left,ins.top,this);
    }

    private void gameUpdate(double timeVar) {
        for(int i=0;i<ballNum;i++){
            ball[i].update(timeVar); 
        }
    }

    private void start() {
        setTitle("Game Loop");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        
        ins = getInsets();
        setSize(wHeight,wWidth);
        bufferedImage = new BufferedImage(wHeight,wWidth,BufferedImage.TYPE_INT_RGB);

        ball= new Ball[ballNum];
        for(int i=0;i<ballNum;i++){
            ball[i] = new Ball();
            ball[i].x = Math.random()*640;
            ball[i].y = Math.random()*300; 
            ball[i].fx = Math.random()*10;
            ball[i].fy = Math.random()*10;

        }
        
        


        /*
        System.out.println(getInsets().bottom);
        System.out.println(getInsets().left);
        System.out.println(getInsets().right);
        System.out.println(getInsets().top);
        */
    }
}
