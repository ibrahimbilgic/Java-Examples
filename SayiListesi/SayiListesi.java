package SayiListesi;

import javax.lang.model.element.Element;

public class SayiListesi {
    int[] liste;
    int elemanSayisi;
    int sinir;
    public SayiListesi(int elemanKapasitesi){
        liste = new int[elemanKapasitesi];
        elemanSayisi = 0;
        sinir = elemanKapasitesi;
    }
    public void listeyeEkle(int eklenecek){
        if(elemanSayisi<sinir){
            liste[elemanSayisi] = eklenecek;
            elemanSayisi++;
        }
        else{
            System.out.println("Ekleme yapamazsınız");
        }
    }
    public void yaz(){
        for(int i=0;i<elemanSayisi;i++){
            System.out.print(liste[i]+ " ");
        }
    }
    public void sil(int index){
        if(index>=0 && elemanSayisi>0 && index <= elemanSayisi-1){
            for(int i=index; i<elemanSayisi-1;i++){
                liste[i] = liste[i+1];
                
            }
            elemanSayisi--;
        }
        else{
            System.out.println("silme işlemi başarısız..");
        }

    }
    public void ekle(int eklenecek,int index){
        if(index>=0 && index<=elemanSayisi && elemanSayisi<sinir){
            for(int i=elemanSayisi-1;i>=index;i--){
                liste[i+1] = liste[i];
            }
            liste[index] = eklenecek;
            elemanSayisi++;
        }
        else{
            System.out.println("Ekleme yapılamadı");
        }
    }
    public int max(){
        int enBuyuk = liste[0];
        for(int i=0;i<elemanSayisi;i++){
            if(liste[i] > enBuyuk){
                enBuyuk = liste[i];
            }
        }
        return enBuyuk;
    }
    public int min(){
        int enKucuk = liste[0];
        for(int i=0;i<elemanSayisi;i++){
            if(liste[0] < enKucuk){
                enKucuk = liste[i];
            }
        }
        return enKucuk;
    }
    public void swap(int a,int b){
        int temp;
        temp = liste[a];
        liste[a] = liste[b];
        liste[b] = temp;
    }
    public void selectionSort(){
        int enKucukIndex;
        for(int i=0;i<elemanSayisi;i++){
            enKucukIndex = i;
            for(int j=i;j<elemanSayisi;j++){
                if(liste[j] < liste[enKucukIndex]){
                    enKucukIndex = j;
                }
            }
            swap(enKucukIndex,i);            
        }
    }
    public void selectionSortTers(){
        int enBuyukIndex;
        for(int i=0;i<elemanSayisi;i++){
            enBuyukIndex = i;
            for(int j=i;j<elemanSayisi;j++){
                if(liste[j] > liste[enBuyukIndex]){
                    enBuyukIndex = j;
                }
            }
            swap(enBuyukIndex,i);            
        }
    }
    public void bubbleSort(){
        boolean swapped = true;
        while(swapped){
            swapped = false;
            for(int i=1;i<elemanSayisi;i++){
                if(liste[i-1] > liste[i]){
                    swap(i-1,i);
                    swapped = true;
                }
            }
        }
    }
    public static void main(String[] args) {
        SayiListesi sy = new SayiListesi(5);
        sy.ekle(5, 0);
        sy.ekle(23, 1);
        sy.ekle(17, 2);
        sy.ekle(87, 3);
        sy.ekle(1, 4);

        sy.yaz();
        sy.selectionSort();
        System.out.println("\n");
        sy.yaz();
        System.out.println("\n");
        sy.selectionSortTers();
        sy.yaz();
        System.out.println("\n");

        sy.bubbleSort();
        sy.yaz();
    }

}
