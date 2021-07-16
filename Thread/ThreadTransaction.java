public class ThreadTransaction {

    private int sum;
    private boolean isOk;
    
    public ThreadTransaction() {
        sum = 0;
        isOk = false;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public boolean isOk() {
        return isOk;
    }

    public void setOk(boolean isOk) {
        this.isOk = isOk;
    }
    
    
}
