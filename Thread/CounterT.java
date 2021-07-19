public class CounterT {
    private int num;
    private boolean isFind=false;

    public boolean isFind() {
        return isFind;
    }



    public void setFind(boolean isFind) {
        this.isFind = isFind;
    }



    public CounterT() {
        num = 0;
    }
    

    
    public CounterT(int Num) {
        this.num = Num;
    }



    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    
}
