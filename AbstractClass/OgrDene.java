package AbstractClass;

public class OgrDene {
    public static void main(String[] args) {
        Ogr o1 = new FenOgr("Ali",2);
        Ogr o2 = new MatOgr("Ayse",3);
        Ogr o3 = new PsiOgr("Veli",4);


        o1.adSoyle();
        o2.adSoyle();
        o3.adSoyle();

        ((FenOgr)o1).bil(); //casting gerekli.
        ((MatOgr)o2).hesapla();
        o3.bolumSoyle();
        ((MatOgr)o2).bilgisayardaYaz();
    }
    
}
