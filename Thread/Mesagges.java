/**
 * Mesagges
 */
public class Mesagges implements Runnable{
    final private int times = 5;
    private int displayed;
    public Mesagges() {
        displayed = 0;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while(displayed<times){
            System.out.println("this is a message - MessagesClass");
            displayed++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
    
    
}