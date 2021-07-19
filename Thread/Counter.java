public class Counter implements Runnable{
    private CounterT start;
    private final int count = 3;
    private int times;
    private int hTimes;
    //private boolean isFind=false;
    public Counter(CounterT startNum, int gTimes) {
        this.start = startNum;
        this.times = gTimes;
        this.hTimes = 0;
    }

    @Override
    public void run() {
        while(hTimes<times){
            start.setNum(start.getNum()+count);
            hTimes++;
            //System.out.println("Num value : "+start.getNum());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Result has found");
        start.setFind(true);
    }
    
}
