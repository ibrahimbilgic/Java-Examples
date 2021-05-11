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
    
    public TxtRead(String path){
        listRecords.addAll(readTxt(path));
        //System.out.println(readTxt(path).get(0).getCategory());
    }

    public ArrayList<Records> readTxt(String path){
                
        ArrayList<Records> list = new ArrayList<>();
        ArrayList<String> listTemp = new ArrayList<String>();
        ArrayList<Integer> tempRecordGroup = new ArrayList<>();
        LocalDate tempYear;
        int i = 2;
    
        File file = new File(path);
        Scanner scan;
        try {
            scan = new Scanner(file);

            String line;
            String title = scan.nextLine();
            String xAxis = scan.nextLine();

            //System.out.println(Title); // to see title
            //System.out.println(xAxis);  // to see xAxis
             
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
        Collections.sort(listRecords);
    }


    public static void main(String[] args) throws FileNotFoundException{ //FileNotException düzelt..
        String path = "/home/blgc/Masaüstü/VisProProject/brand_values.txt";
        TxtRead dene = new TxtRead(path);
        listRecords.sort(null); // null problem !!!
        System.out.println(listRecords.get(21605).getValue());
    }
}
