package PazarListesi;

public class PazarListesi {
    //Basit bir pazar listesi -- Giris düzey
    String[] liste;
    int elemanSayisi;
    int sinir;
    public PazarListesi(int elemanKapasitesi){
        liste = new String[elemanKapasitesi];
        elemanSayisi = 0;
        sinir = elemanKapasitesi;
    }   
    public void listeyeEkle(String eklenecekString){
        if(elemanSayisi<sinir){
            liste[elemanSayisi] = eklenecekString;
            elemanSayisi++;
        }
        else{
            System.out.println("Eleman eklenemedi..");
        }

    }
    public void yaz(){
        for(int i = 0;i<elemanSayisi;i++){
            System.out.println(liste[i]);
        }
    }/*
    public void sondanSil(){
        if(elemanSayisi>0){
            elemanSayisi--;
            liste[elemanSayisi] = "";
        }
        else
        {
            System.out.println("Listeniz boş..");
        }
        
    }
    public void bastanSil(){
        for(int i=0;i<elemanSayisi-1;i++){
            liste[i] = liste[i+1];
        }
        elemanSayisi--;
    }*/
    public void sil(int index){
        if(index<=elemanSayisi-1 && index>=0 && elemanSayisi>0){
            for(int i=index; i<elemanSayisi-1;i++){
                liste[i] = liste[i+1];
            }
            elemanSayisi--;
        }
        else{
            System.out.println("Silme işlemi gerçekleştirilemedi.");
        }
        
    }
    public void ekle(String eklenecek,int index){
        if(index<=elemanSayisi && index>=0 && elemanSayisi < sinir){
            for(int i=elemanSayisi-1;i>=index;i--){
                liste[i+1] = liste[i];
            }
            liste[index] = eklenecek;
            elemanSayisi++;
            
        }
        else{
            System.out.println("Ekleme yapamazsınız");
        }
        
    }
    public String max(){
        String enBuyuk = liste[0];
        for(int i=0;i<elemanSayisi;i++){
            if(liste[i].compareToIgnoreCase(enBuyuk)>0){
                enBuyuk = liste[i];
            }
        }
        return enBuyuk;
    }
    public String min(){
        String enKucuk = liste[0];
        for(int i=0;i<elemanSayisi;i++){
            if(liste[i].compareToIgnoreCase(enKucuk)<0){
                enKucuk = liste[i];
            }
        }
        return enKucuk;
    }
    public void swap(int a,int b){
        String temp;
         temp = liste[a];
        liste[a] = liste[b];
        liste[b] = temp;
    }
    
    public static void main(String[] args) {
        PazarListesi pzr = new PazarListesi(3);
        pzr.listeyeEkle("ekmek");
        pzr.listeyeEkle("su");
        pzr.listeyeEkle("pasta");
        //pzr.yaz();

        //pzr.sondanSil();
        //pzr.yaz();

        //pzr.bastanSil();
        //pzr.yaz();

        
        pzr.sil(1);
        pzr.yaz();
        
        pzr.ekle("köfte", 2);
        pzr.yaz();

        pzr.sil(0);
        pzr.ekle("dolma", 0);
        pzr.yaz();

        pzr.ekle("tatlı", 4);//ekleme yapılamayacak.
        String maxDeger = pzr.max();
        System.out.println("Enbüyük: "+maxDeger);

        System.out.println("Enkücük: "+pzr.min()); 

    }


}
