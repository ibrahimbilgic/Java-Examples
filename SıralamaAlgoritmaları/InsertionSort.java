package SıralamaAlgoritmaları;

class InsertionSort {

    //Araya sokma sıralama algoritması
    public static void main(String[] args) {

        int[] numbers = new int[] {12,11,9,71,18,17};
        InsertionSort(numbers);

    }
    public static void InsertionSort(int[] dizi){
        int N = dizi.length;

        int i,k,ekle;

        for(i=1;i<N;i++){
            ekle=dizi[i];
            for(k=i-1;k>=0 && ekle<= dizi[k];k--){
                dizi[k+1] = dizi[k];
            }
            dizi[k+1] = ekle;
            adımGor(dizi, N); //Algoritmanın her adımını görelim.
        }
        
    }
    public static void adımGor(int[] dizi,int N){
        for(int i=0; i<N; i++){
            System.out.print(dizi[i]+" ");
        }
        System.out.print("\n");
    }
    
}
