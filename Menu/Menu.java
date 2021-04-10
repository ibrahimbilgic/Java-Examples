import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        MenuGoster();
    }
    public static void MenuGoster(){
        int x = 0;
        Scanner scan = new Scanner(System.in);

        while(x!= 4){
            x = scan.nextInt();

            System.out.println("1. Ara");
            System.out.println("2. Kaydet");
            System.out.println("3. Yükle");
            System.out.println("4. Çıkış");

            if(x == 1)
                System.out.println("Arama yapıldı..");
            else if(x == 2)
                System.out.println("Kayıt yapıldı");
            else if(x==3)
                System.out.println("Yükleme yapıldı");
            else if(x==4)   
                System.out.println("Çıkış yapılıyor..");
            else  
                System.out.println("Yanlış değer girdiniz..");
        }

    }
}
