package IlkPencere;
import javax.swing.JPanel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ButonDene extends JPanel implements ActionListener{
    
    JButton button1,button2;
    JLabel label1;
    @Override
    public void actionPerformed(ActionEvent e) {
        //Herhangi bir olay tetiklenirse işlem yapabiliyoruz.
        if(e.getActionCommand().equals("Arttır"))
        {
            int a = Integer.parseInt(label1.getText());
            a += 1;
            label1.setText(""+a);
        }
        else if(e.getActionCommand().equals("Azalt")){
            int a = Integer.parseInt(label1.getText());
            a -=1;
            label1.setText(""+a);
        }
        
    }

    
    public ButonDene(){
        super();
        button1 = new JButton("Arttır");
        button1.addActionListener(this);
        button2 = new JButton("Azalt");
        button2.addActionListener(this);
        label1 = new JLabel("0");
        add(button1);
        add(button2);
        add(label1);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Deneme");
        ButonDene panel1 = new ButonDene();
        frame.add(panel1);
        frame.setSize(640,480);
        frame.setVisible(true);


    }
}
