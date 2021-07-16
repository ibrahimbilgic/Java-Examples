public class ThreadSecond implements Runnable{
    
    ThreadTransaction transaction;
    int num,index,lastNum;

    public ThreadSecond(ThreadTransaction t) {
        this.transaction = t;
        num = 10;
        index = 2;
    }

    @Override
    public void run() {
        lastNum = 1;
        transaction.setSum(1);
        while(index < num){
            int temp = transaction.getSum();
            transaction.setSum(lastNum+transaction.getSum());
            lastNum = temp;
            index++;

            try {
                Thread.sleep(100);
                System.out.println("waiting... SecondThread");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        transaction.setOk(true);
    }
    
}
