public class ThirdMain {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Mesagges());
        t1.start();
        while(t1.isAlive()){
            System.out.println("t1 is alive");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println(t1.getState());
    }
}
