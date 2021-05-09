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
    JFrame frameReferans;
    JLabel soruMetniLabel,skorLabel;
    JRadioButton cevapA,cevapB,cevapC,cevapD;
    JButton onayButton;
    ButtonGroup cevaplar;
    
    Soru[] sorular = new Soru[5];
    int gecerliSoru = 0;
    int skor = 0;
    int maxSoru = 0;

    public SoruDeneme(JFrame frame) {
        frameReferans = frame;

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
        }
        else if(cevapB.isSelected())
        {
            cevapDogruMu = cevapKontrol(Soru.Cevap.CEVAP_B);
        }
        else if(cevapC.isSelected())
        {
            cevapDogruMu = cevapKontrol(Soru.Cevap.CEVAP_C);
        }
        else if(cevapD.isSelected())
        {
            cevapDogruMu = cevapKontrol(Soru.Cevap.CEVAP_D);
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
        cevaplar.clearSelection();   
    }
    public void sorularıOlustur(){
        
        try
        {
            FileReader dosyaOkuyucu = new FileReader("//home//blgc//Masaüstü//Java-Examples//IlkPencere//soru");
            BufferedReader okuyucu  = new BufferedReader(dosyaOkuyucu); //sıralı bilgi içeren dosyaları okumak için

            String satir;

            while((satir = okuyucu.readLine()) != null){
                String soruMetni = satir;
                String secenekA = okuyucu.readLine();
                String secenekB = okuyucu.readLine();
                String secenekC = okuyucu.readLine();
                String secenekD = okuyucu.readLine();
                String dogruCevapMetni = okuyucu.readLine();

                Soru.Cevap dogruCevap = null;

                if(dogruCevapMetni.equalsIgnoreCase("A")){
                    dogruCevap = Soru.Cevap.CEVAP_A;
                }
                else if(dogruCevapMetni.equalsIgnoreCase("B")){
                    dogruCevap = Soru.Cevap.CEVAP_B;
                }
                else if(dogruCevapMetni.equalsIgnoreCase("C")){
                    dogruCevap = Soru.Cevap.CEVAP_C;
                }
                else if(dogruCevapMetni.equalsIgnoreCase("D")){
                    dogruCevap = Soru.Cevap.CEVAP_D;
                }
                if(dogruCevap != null){
                    sorular[maxSoru] = new Soru(soruMetni,secenekA,secenekB,secenekC,secenekD,dogruCevap);
                    maxSoru++;
                }
            }

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
        frameReferans.pack();

    }
    public boolean cevapKontrol(Soru.Cevap verilenCevap){
        return sorular[gecerliSoru].cevapKontrol(verilenCevap);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();    
        frame.add(new SoruDeneme(frame));
        frame.setVisible(true);
        frame.setBounds(100,100,200,150);

    }
    
}
