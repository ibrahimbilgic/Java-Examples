package IlkPencere;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class SoruDeneme extends JPanel implements ActionListener{

    JLabel soruMetniLabel,skorLabel;
    JRadioButton cevapA,cevapB,cevapC,cevapD;
    JButton onayButton;
    ButtonGroup cevaplar;
    
    Soru[] sorular = new Soru[5];
    int gecerliSoru = 0;
    int skor = 0;
    int maxSoru = 5;

    public SoruDeneme() {

        //Elemanları oluşturma kısmı..

        
        soruMetniLabel = new JLabel();
        skorLabel = new JLabel("Skor: " + skor);
        cevapA = new JRadioButton();
        cevapB = new JRadioButton();
        cevapC = new JRadioButton();
        cevapD = new JRadioButton();
        onayButton = new JButton("Onaylıyorum");
        
        cevaplar = new ButtonGroup();
        cevaplar.add(cevapA);
        cevaplar.add(cevapB);
        cevaplar.add(cevapC);
        cevaplar.add(cevapD);

        onayButton.addActionListener(this);
        add(soruMetniLabel);
        
        add(cevapA);
        add(cevapB);
        add(cevapC);
        add(cevapD);

        add(onayButton);

        add(skorLabel);
        //Soruları oluşturma
        sorularıOlustur();
        soruyuGoster(gecerliSoru);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean cevapDogruMu;
        if(cevapA.isSelected())
        {
            cevapDogruMu = cevapKontrol(Soru.Cevap.CEVAP_A);
            cevapA.setSelected(true);
        }
        else if(cevapB.isSelected())
        {
            cevapDogruMu = cevapKontrol(Soru.Cevap.CEVAP_B);
            cevapB.setSelected(false);
        }
        else if(cevapC.isSelected())
        {
            cevapDogruMu = cevapKontrol(Soru.Cevap.CEVAP_C);
            cevapC.setSelected(false);
        }
        else if(cevapD.isSelected())
        {
            cevapDogruMu = cevapKontrol(Soru.Cevap.CEVAP_D);
            cevapD.setSelected(false);
        }
        else
        {
            cevapDogruMu = false;
        }
        if(cevapDogruMu)
        {
            JOptionPane.showMessageDialog(this, "Doğru cevap verdiniz.");
            skor+=10;
            skorLabel.setText("Skor: "+ skor);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Yanlış cevap verdiniz.");
            skor-=10;
            skorLabel.setText("Skor: "+ skor);
        }

        gecerliSoru++;
        if(gecerliSoru < maxSoru)
        {
            soruyuGoster(gecerliSoru);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "oyun bitti. Skorun: "+skor);
        }
        
        
        
    }
    public void sorularıOlustur(){
        
        try
        {
            FileReader dosyaOkuyucu = new FileReader("//home//blgc//Masaüstü//Java-Examples//IlkPencere//soru");
            BufferedReader okuyucu  = new BufferedReader(dosyaOkuyucu); //sıralı bilgi içeren dosyaları okumak için

            String satir = okuyucu.readLine();
            System.out.println(satir);
            System.out.println(okuyucu.readLine());
            System.out.println(okuyucu.readLine());


            okuyucu.close();
            dosyaOkuyucu.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
        
    }
    public void soruyuGoster(int soruNo){
        soruMetniLabel.setText(sorular[soruNo].soruMetni);
        cevapA.setText(sorular[soruNo].secenekA);
        cevapB.setText(sorular[soruNo].secenekB);
        cevapC.setText(sorular[soruNo].secenekC);
        cevapD.setText(sorular[soruNo].secenekD);

    }
    public boolean cevapKontrol(Soru.Cevap verilenCevap){
        return sorular[gecerliSoru].cevapKontrol(verilenCevap);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        SoruDeneme sd = new SoruDeneme();        
        frame.add(sd);
        frame.setVisible(true);
        frame.setSize(640,480);

    }
    
}
