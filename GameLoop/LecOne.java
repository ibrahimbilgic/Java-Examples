import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class LecOne extends JFrame{
    private int wHeight = 640;
    private int wWidth = 480;
    private Insets ins;
    private int targetFPS = 30;
    private BufferedImage bufferedImage;
    private boolean isGameCont = true;
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
             
            //Update
            gameUpdate();

            //Render
            gameGraphicUpdate();
        }

    }

    private void gameGraphicUpdate() {
        Graphics frameGraphics = getGraphics();

        Graphics bufferGraphics = bufferedImage.getGraphics();

        // buffer update
        bufferGraphics.setColor(Color.WHITE);
        bufferGraphics.fillRect(0, 0, wHeight, wWidth);

        bufferGraphics.setColor(Color.BLACK);
        bufferGraphics.fillRect(20, 20, 30, 30);

        //Buffer -> Frame -> Paint
        frameGraphics.drawImage(bufferedImage,ins.left,ins.top,this);
    }

    private void gameUpdate() {
    }

    private void start() {
        setTitle("Game Loop");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        
        ins = getInsets();
        setSize(wHeight,wWidth);
        bufferedImage = new BufferedImage(wHeight,wWidth,BufferedImage.TYPE_INT_RGB);

        /*
        System.out.println(getInsets().bottom);
        System.out.println(getInsets().left);
        System.out.println(getInsets().right);
        System.out.println(getInsets().top);
        */
    }
}
