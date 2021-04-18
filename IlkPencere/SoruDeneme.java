package IlkPencere;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SoruDeneme extends JPanel implements ActionListener{

    JLabel soruMetniLabel;
    JRadioButton cevapA,cevapB,cevapC,cevapD;
    JButton onayButton;
    ButtonGroup cevaplar;
    
    Soru[] sorular = new Soru[5];
    int gecerliSoru = 0;

    public SoruDeneme() {
        
        soruMetniLabel = new JLabel();
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
    public void sorularıOlustur(){
        sorular[0] = new Soru("Hangisi bir programlama dili değildir?","java","python","c++","py",Soru.Cevap.CEVAP_D);
        sorular[1] = new Soru("Hangisi bir programlama dili değildir?","java","python","c++","py",Soru.Cevap.CEVAP_D);
        sorular[2] = new Soru("Hangisi bir programlama dili değildir?","java","python","c++","py",Soru.Cevap.CEVAP_D);
        sorular[3] = new Soru("Hangisi bir programlama dili değildir?","java","python","c++","py",Soru.Cevap.CEVAP_D);
        sorular[4] = new Soru("Hangisi bir programlama dili değildir?","java","python","c++","py",Soru.Cevap.CEVAP_D);
        
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
        sd.sorularıOlustur();
        sd.soruyuGoster(0);
        frame.add(sd);
        frame.setVisible(true);
        frame.setSize(640,480);

    }
    
}
