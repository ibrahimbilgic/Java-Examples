package SayiTahmin;

import java.util.Random;
import java.util.Scanner;

public class SayiTahmin {
    public static void main(String[] args) {
        Random rn = new Random();
        
        int cevap = rn.nextInt(100);
        System.out.println(cevap);
        int kullaniciTahmin = 0;
        boolean oyunDevamSarti = true;
        Scanner scan = new Scanner(System.in);
        int count = 1;

        while(oyunDevamSarti){
            System.out.print("Bir sayi giriniz: ");
            kullaniciTahmin = scan.nextInt();

            if(kullaniciTahmin == cevap){
                System.out.println(count+". adımda bildiniz..");
                oyunDevamSarti = false;
            }
            else if(kullaniciTahmin<cevap){
                System.out.println("Kücük bir sayi girdiniz..");
                count++;
                oyunDevamSarti = true; // oyun devam etsin
            }
            else if(kullaniciTahmin>cevap){
                System.out.println("Büyük bir sayi girdiniz..");
                count++;
                oyunDevamSarti = true; //oyun devam etsin
            }

        }
    }
}
