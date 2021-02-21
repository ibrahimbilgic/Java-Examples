package SıralamaAlgoritmaları;

class BubbleSort {
    public static void main(String[] args) {
        int[] numbers = new int[]{20,34,145,9,3,4};
        bubbleSort(numbers);

    }
    public static void bubbleSort(int[] dizi){
        int N = dizi.length;
        int gecici,k;
        
        for(int hareket = 0; hareket<N-1; hareket++){
            adımGor(dizi,dizi.length); //Algoritmanın her adımını görelim
            for(k=0; k<(N-1-hareket); k++){
                if(dizi[k] > dizi[k+1]){
                    gecici = dizi[k];
                    dizi[k] = dizi[k+1];
                    dizi[k+1] = gecici;
                }
            }
        }

    }
    public static void adımGor(int[] dizi,int N){
        for(int i=0; i<N; i++){
            System.out.print(dizi[i]+" ");
        }
        System.out.print("\n");
    }
    
}
