public class Dene {
    public static void main(String[] args) {
        String path = "/home/blgc/Masaüstü/VisProProject/city_populations (kopya).txt";
        TxtRead dene = new TxtRead(path);
        dene.sort();
        System.out.println(TxtRead.listRecords.get(3));
    }
}
