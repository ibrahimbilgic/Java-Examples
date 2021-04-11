package AbstractClass;

public class MatOgr extends Ogr implements Bil{

    public MatOgr(String isim, int no) {
        super(isim, no);

    }
    public void hesapla(){
        System.out.println("Hesapladım");
    }
    @Override
    public void bolumSoyle() {
        //Abstract metodun içini doldur.
        System.out.println("Bölümüm Matematik");
        
    }
    @Override
    public int bilgi(int a,int b) {
        // TODO Auto-generated method stub
        return a*b;   
    }
    @Override
    public void bilgisayardaYaz() {
        // TODO Auto-generated method stub
        System.out.println("Yazdım");
    }
    
    
    
    
}
