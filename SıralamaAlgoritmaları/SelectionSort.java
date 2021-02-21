package SıralamaAlgoritmaları;

class SelectionSort {
    //Seçmeli sıralama Algoritması
    public static void main(String[] args) {
        int[] numbers = new int[]{21,8,7,11,3,4};
        selectionSort(numbers);
    }

    public static void selectionSort(int[] dizi){
        
        int N = dizi.length;
        
        int index,enKucuk;
        for(int i=0; i<N-1; i++){
            enKucuk = dizi[N-1];
            index = N-1;
            for(int j=i; j<(N-1); j++){
                if(dizi[j]<enKucuk){
                    enKucuk = dizi[j];
                    index = j;
                }

            }
            dizi[index] = dizi[i];
            dizi[i] = enKucuk;
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
