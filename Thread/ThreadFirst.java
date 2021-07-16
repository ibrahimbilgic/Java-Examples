public class ThreadFirst implements Runnable{

    ThreadTransaction transaction;
    public ThreadFirst(ThreadTransaction t) {
        this.transaction = t;
    }

    @Override
    public void run() {
        while(!transaction.isOk()){
            try {

                Thread.sleep(500);
                System.out.println("waiting... FirstThread");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("Ready. result: "+transaction.getSum());
    }
    
}
