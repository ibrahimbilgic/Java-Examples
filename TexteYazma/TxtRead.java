import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TxtRead {
    static ArrayList<Records> listRecords = new ArrayList<>();
    ArrayList<Integer> tempRecordGroup = new ArrayList<>();
    ArrayList<Records> list = new ArrayList<>();
    ArrayList<String> listTemp = new ArrayList<String>();
    LocalDate tempYear;
    int i = 2;

    public TxtRead(String path){ //Constructer
        listRecords.addAll(readTxt(path));
    }

    public ArrayList<Records> readTxt(String path){
        File file = new File(path);
        Scanner scan;
        try {
            scan = new Scanner(file);

            String line;
            String title = scan.nextLine();
            String xAxis = scan.nextLine();
             
            while(scan.hasNext()){
                line = scan.nextLine();
                if(line.length()>0){
                    if(!line.contains(",")){
                        tempRecordGroup.add(Integer.parseInt(line));
                        continue;
                    }
        
                    listTemp.add(line);
                    String dizi[] = listTemp.get(i-2).split(",");
        
                    String str = "^\\d{4}-\\d{2}-\\d{2}$";
                    Pattern pattern = Pattern.compile(str);
                    Matcher matcher = pattern.matcher(dizi[0]);
        
                    if(matcher.matches()){
                        tempYear= LocalDate.parse(dizi[0]);
                    }
                    else{
                        tempYear = LocalDate.of(Integer.parseInt(dizi[0]),1,1);
                    }
        
                    String tempname = dizi[1];
                    String tempCountry = dizi[2];
                    int tempValue = Integer.parseInt(dizi[3]);
                    String tempCategory = dizi[4];
        
                    Records kayitlar = new Records(tempYear, tempname, tempCountry, tempValue, tempCategory);
        
                    list.add(kayitlar);
                    i++;
                }
                else{
                    continue;
                }
        
            }
            scan.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return list;
    }
    public void sort(){
        int count = 0;
        for(int i=0;i<tempRecordGroup.size();i++){
            Collections.sort(listRecords.subList(count, count+tempRecordGroup.get(i)));
            count += tempRecordGroup.get(i);
        }
        System.out.println("Calistim"); //çalışıp çalışmadığını gör...
    }
    public static void main(String[] args) throws FileNotFoundException{ //FileNotException düzelt..
        String path = "/home/blgc/Masaüstü/VisProProject/city_populations (kopya).txt";
        TxtRead dene = new TxtRead(path);
    
        //System.out.println(listRecords.get(21670).getValue());
        //System.out.println(listRecords.get(21671).getValue());
        /*for(int i=0; i<15;i++){
            System.out.println(listRecords.get(i));
        }*/
        dene.sort();
        for(int i=0;i<listRecords.size();i++){
            System.out.println(listRecords.get(i));
        }

        //System.out.println(listRecords.size()); 
    }
}
