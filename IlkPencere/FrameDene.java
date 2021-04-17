package IlkPencere;

import javax.swing.JFrame;

public class FrameDene extends JFrame{
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new CheckBox());
        frame.setBounds(100,100,200,200);
        frame.setVisible(true);
    }
}
