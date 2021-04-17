package IlkPencere;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class RadioButton extends JPanel implements ActionListener{
    JRadioButton radioButton,radioButton2,radioButton3,radioButton4;
    JRadioButton r1,r2;
    JLabel label,label2;
    JButton button;
        
    //gruplama için
    ButtonGroup grup,grup2;

    public RadioButton() {
        //grup oluştur..
        grup = new ButtonGroup();
        grup2 = new ButtonGroup();
        
        //Labeller
        label = new JLabel("sınıfınızı seçin: ");
        label2 = new JLabel("Cinsiyetiniz: ");

        //radiobuttonlar oluşturuldu.
        radioButton = new JRadioButton("1. sınıf");
        radioButton2 = new JRadioButton("2. sınıf");
        radioButton3 = new JRadioButton("3. sınıf");
        radioButton4 = new JRadioButton("4. sınıf");

        r1 = new JRadioButton("Kadın");
        r2 = new JRadioButton("Erkek");

        button = new JButton("Sınıfı seç");
        button.addActionListener(this);
        //sınıf sorusu için
        add(label);
       
        grup.add(radioButton);
        grup.add(radioButton2);
        grup.add(radioButton3);
        grup.add(radioButton4);

        grup2.add(r1);
        grup2.add(r2);
        
        add(radioButton);
        add(radioButton2);
        add(radioButton3);        
        add(radioButton4);

        //Cinsiyet için
        add(label2);
        add(r1);
        add(r2);

        add(button);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = "Seçilen sınıf ";
        boolean isChecked = false;
        if(radioButton.isSelected())
        {
            s+=radioButton.getText();
            isChecked = true;
        }
        else if(radioButton2.isSelected())
        {
            s+=radioButton2.getText();
            isChecked = true;
        }
        else if(radioButton3.isSelected())
        {
            s+=radioButton3.getText();
            isChecked = true;
        }
        else if(radioButton4.isSelected())
        {
            s+=radioButton4.getText();
            isChecked = true;
        }
        else
        {
            s = "Lütfen seçim yapın";
        }
        if(isChecked)
        {
            if(r1.isSelected())
            {
                s+= ", cinsiyet "+r1.getText();
            }
            else if(r2.isSelected())
            {
                s+= ", cinsiyet "+r2.getText();
            }
            else
            {
                s = "Lütfen seçim yapın";
            }
        }
        

        JOptionPane.showMessageDialog(this, s);
    }
    
}
