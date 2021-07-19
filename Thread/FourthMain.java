public class FourthMain {
    public static void main(String[] args) {
        int firstNum = 10;
        int hTimes = 20;

        CounterT counterT = new CounterT();
        Thread t1 = new Thread(new Counter(counterT, hTimes));
        t1.start();

        try {
            t1.join(); // t1 terminated state olana kadar maain threadi bekletebiliriz.
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
/*
        while(t1.isAlive()){
            if(!counterT.isFind()){
                System.out.println("has not been found");
            }
            else{
                System.out.println("Has been found");
            }
            //System.out.println(t1.getState());
            //System.out.println("FirstNum : "+counterT.getNum());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
 */
    }
}
