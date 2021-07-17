public class SecondMain {

    public SecondMain() {
    }
    
    public static void main(String[] args) {
       
        PresentNum p = new PresentNum();

        Thread t1 = new Thread(new Raise(p));
        Thread t2 = new Thread(new Decrease(p));

        t1.start();
        t2.start();
        
    }
}
