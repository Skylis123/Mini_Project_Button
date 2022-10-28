import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class RandomNumber {
    int number;
    public int rng (int n) {
        Random rng = new Random();
        number = rng.nextInt(n) + 1;
        return number;
    }
}
public class MyFrame extends JFrame implements ActionListener{
    JButton textFieldButton;
    JButton[] button = new JButton[100];
    JTextField textField;
    int number, ok_rng = 0,correctNumber;
    MyFrame() {
        textFieldButton = new JButton("Submit");
        textFieldButton.addActionListener(this);
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(300,40));
        this.add(textField);
        this.add(textFieldButton);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setSize(400,400);
        this.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
       if (e.getSource() == textFieldButton) {
           ImageIcon icon_normal = new ImageIcon("normal.PNG");
           Image get_icon = icon_normal.getImage();
           Image new_icon = get_icon.getScaledInstance(40, 40 , Image.SCALE_SMOOTH);
           icon_normal = new ImageIcon(new_icon);
           number = Integer.parseInt(textField.getText());
           for (int i = 1; i <= number; ++i) {
               button[i] = new JButton();
               button[i].addActionListener(this);
               button[i].setIcon(icon_normal);
               this.add(button[i]);
           }
           validate();
           repaint();
       }
       if (ok_rng == 0){
           RandomNumber nr = new RandomNumber();
           correctNumber = nr.rng(number);
           ok_rng = 1;
       }

       int ok = 0, position = 0;
       ImageIcon icon_happy = new ImageIcon("happy.PNG");
       Image get_icon_happy = icon_happy.getImage();
       Image new_icon_happy = get_icon_happy.getScaledInstance(40, 40 , Image.SCALE_SMOOTH);
       icon_happy = new ImageIcon(new_icon_happy);

       ImageIcon icon_sad = new ImageIcon("sad.PNG");
       Image get_icon_sad = icon_sad.getImage();
       Image new_icon_sad = get_icon_sad.getScaledInstance(40, 40 , Image.SCALE_SMOOTH);
       icon_sad = new ImageIcon(new_icon_sad);

       for (int i = 1; i <= number; ++i) {
           if(e.getSource() == button[i]) {
               position = i;
               if (i == correctNumber) {
                   button[i].setIcon(icon_happy);
                   ok = 1;
                   break;
               }
           }
       }
        if (ok == 0) {
            button[position].setIcon(icon_sad);
        }
    }
}