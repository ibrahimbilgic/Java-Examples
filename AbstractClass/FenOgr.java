package AbstractClass;

public class FenOgr extends Ogr{

    public FenOgr(String isim, int no) {
        super(isim, no);
    }
    public void bil(){
        System.out.println("Bildim.");
    }
    @Override
    public void bolumSoyle() {
        // Abstract metodun içini doldur
        System.out.println("Fen öğrencisiyim..");
        
    }
    
    
}
