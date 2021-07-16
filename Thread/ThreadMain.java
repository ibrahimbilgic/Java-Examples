public class ThreadMain {

    public ThreadMain() {

    }

    public static void main(String[] args) {
        ThreadTransaction transaction = new ThreadTransaction();

        Thread t1 = new Thread(new ThreadFirst(transaction));
        t1.start();

        Thread t2 = new Thread(new ThreadSecond(transaction));
        t2.start();
    }
    
}
