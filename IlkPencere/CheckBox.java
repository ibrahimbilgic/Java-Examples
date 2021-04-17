package IlkPencere;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class CheckBox extends JPanel implements ActionListener{

    JCheckBox check1,check2;
    JButton button1;

    public CheckBox() {
        check1 = new JCheckBox("Burs Alıyor mu?");
        add(check1);
        check2 = new JCheckBox("Yurtta kalıyor mu?");
        add(check2);
        button1 = new JButton("Tamamla");
        button1.addActionListener(this);
        add(button1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = "Öğrenci ";
     if(check1.isSelected())
     {
    
        s += "Yurtta kalıyor ";
        
     }   
     else
     {
        s += "Yurtta kalmıyor ";
     } 
     
     if(check2.isSelected())
     {
        s += "Burs alıyor";  
     }   
     else
     {
         s += "Burs almıyor";
     }

     JOptionPane.showMessageDialog(this, s); //açılır pencere.. message dialog
     
    }
    
}
