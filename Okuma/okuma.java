import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class okuma {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<String>();
        File file = new File("/home/blgc/Masaüstü/VisProProject/testdata.txt");
        Scanner scan = new Scanner(file);

        while (scan.hasNextLine()){
            list.add(scan.nextLine());
        }
        
        String[] temp;
        int sizeofList = list.size();
        String[] allValues = new String[sizeofList-1];
        String[] allNames = new String[sizeofList-1];
        String[] allDates = new String[sizeofList-1];
        String[] allCountries = new String[sizeofList-1];
        String[] allCategories = new String[sizeofList-1];


        for(int i =0; i< list.size()-1;i++){

            temp =list.get(i).split("[,]");
            allValues[i] = temp[3];
            allNames[i] = temp[1];
            allDates[i] = temp[0];
            allCountries[i] = temp[2];
            allCategories[i] = temp[4];


        }

        int a =0;
        for(String dates:allDates) {
            System.out.println((a+1) + ". şirketin tarihi = " + dates.toString());
            a++;
        }

        int j =0;
        for(String names:allNames) {
            System.out.println((j+1) + ". şirketin ismi = " + names.toString());
            j++;
        }

        int b =0;
        for(String country:allCountries) {
            System.out.println((b+1) + ". şirketin ülkesi = " + country.toString());
            b++;
        }

        int z =0;
        for(String strings:allValues) {
            System.out.println((z+1) + ". şirketin value = " + strings.toString());
            z++;
        }


        int c =0;
        for(String category:allCategories) {
            System.out.println((c+1) + ". şirketin kategorisi = " + category.toString());
            c++;
        }


        scan.close();
    }
}
