public class Raise implements Runnable{

    PresentNum numRef;
    int time = 0;
    public Raise(PresentNum nPresentNum) {
        numRef = nPresentNum;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while(time<100){
            synchronized(numRef){
                numRef.numValue++;
                System.out.println("++: "+ numRef.numValue);
            }
       
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            time++;
        }
    }
    
}
