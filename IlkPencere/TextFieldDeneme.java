package IlkPencere;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TextFieldDeneme extends JPanel implements ActionListener{
    
    JTextField textField1;
    JButton button1;
    JLabel label1;
    public TextFieldDeneme(){
        super(); //super const. cagirilir.
        label1 = new JLabel();
        add(label1);
        
        textField1 = new JTextField(20);
        textField1.addActionListener(this);
        //textfielda action listener eklemek
        add(textField1);
        
        button1 = new JButton("Tamamla");
        button1.addActionListener(this);
        add(button1);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //Tamam butonuna basıldığında devreye girecek..

        if(e.getActionCommand().equals("Tamam"));
        {
            label1.setText("Merhaba "+textField1.getText()+" nasılsın ?");
            textField1.setText("");
            textField1.requestFocus();
        }
        
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Deneme");
        TextFieldDeneme deneme = new TextFieldDeneme();
        frame.add(deneme);
        frame.setSize(640,480);
        frame.setVisible(true);
    }
}
