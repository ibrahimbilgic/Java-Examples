package IlkPencere;

public class Soru {
    String soruMetni;
    String secenekA,secenekB,secenekC,secenekD;
    
    public enum Cevap {CEVAP_A,CEVAP_B,CEVAP_C,CEVAP_D} //2bit
    Cevap dogruCevap;
    public Soru(String soruMetni, String secenekA, String secenekB, String secenekC, String secenekD,
            Cevap dogruCevap) {
        this.soruMetni = soruMetni;
        this.secenekA = secenekA;
        this.secenekB = secenekB;
        this.secenekC = secenekC;
        this.secenekD = secenekD;
        this.dogruCevap = dogruCevap;
    }
    boolean cevapKontrol(Cevap cevap){
        return this.dogruCevap == cevap;
    }

    public static void main(String[] args) { //soruyu test etmek için main metot
        Soru soru1 = new Soru("Hangisi bir programlama dili değildir?","java","python","c++","py",Cevap.CEVAP_D);

        System.out.println(soru1.soruMetni);
        System.out.println(soru1.secenekA);
        System.out.println(soru1.secenekB);
        System.out.println(soru1.secenekC);
        System.out.println(soru1.secenekD);

        System.out.println("seçenek b "+soru1.cevapKontrol(Cevap.CEVAP_B));
        System.out.println("seçenek d "+soru1.cevapKontrol(Cevap.CEVAP_D));
    }

    
    
}
