import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.event.MouseInputListener;

import jdk.jfr.Percentage;

public class LecOne extends JFrame implements MouseInputListener{
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

    boolean tempCircle = false;
    int tempCircleX = 0;
    int tempCircleY = 0;
    int tempCircleW = 0;
    int tempCircleH = 0;

    double pressX1 = 0;
    double pressY1 = 0;

    PhysicEngine pEngine = new PhysicEngine();
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
        pEngine.display(bufferGraphics);
        
        if(tempCircle){
            bufferGraphics.setColor(Color.RED);
            bufferGraphics.drawOval(tempCircleX, tempCircleY, tempCircleW, tempCircleH);
            bufferGraphics.setColor(Color.BLACK);
        }

        //Buffer -> Frame -> Paint
        frameGraphics.drawImage(bufferedImage,ins.left,ins.top,this);
    }

    private void gameUpdate(double timeVar) {
        pEngine.update(timeVar);
    }

    private void start() {
        setTitle("Game Loop");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        
        ins = getInsets();
        setSize(wHeight,wWidth);
        bufferedImage = new BufferedImage(wHeight,wWidth,BufferedImage.TYPE_INT_RGB);

        
        for(int i=0;i<ballNum;i++){
            pEngine.addElement(new Ball(Math.random()*640, Math.random()*300, 
            Math.random()*10, Math.random()*10, (Math.random()*29)+1, (Math.random()*29)+1, (Math.random()*29)+1));
            
        }
        
        
        addMouseListener(this);

        /*
        System.out.println(getInsets().bottom);
        System.out.println(getInsets().left);
        System.out.println(getInsets().right);
        System.out.println(getInsets().top);
        */
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            double size = (Math.random()*29)+1;
            pEngine.addElement(new Ball(
            e.getX() - size/2, 
            e.getY() - size/2, 
            0, 
            0, 
            size,
            size,
            size));
        }
        gameGraphicUpdate();
    }



    

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            pressX1 = e.getX();
            pressY1 = e.getY();

            tempCircleX = e.getX();
            tempCircleY = e.getY();

            tempCircleH = 0;
            tempCircleW = 0;

            tempCircle = true;

        }
    }


    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            double sizeX = Math.abs(pressX1 - e.getX());
            double sizeY = Math.abs(pressY1 - e.getY());
            double m = Math.max(sizeX, sizeY);
     

            pEngine.addElement(new Ball(
            e.getX() - sizeX/2, 
            e.getY() - sizeY/2, 
            0, 
            0, 
            sizeX,
            sizeY,
            m));
            
            tempCircle = false;
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
    public void mouseDragged(MouseEvent e) {
        tempCircleW = Math.abs(tempCircleX - e.getX());
        tempCircleH = Math.abs(tempCircleY - e.getY());
    }


    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
}
