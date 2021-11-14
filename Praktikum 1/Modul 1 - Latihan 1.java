import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BinaryToDecimal {

    public static void main(String[] args) {
        JFrame w = new frameConverts();
        w.setVisible(true);
    }

}


class frameConverts extends JFrame implements ActionListener {
    private JButton btnOK;
    public TextField text;
    public Label decimal;
    int desimal;
    frameConverts(){
        setTitle("Prak1 - Nadya Amanda - 064001900003");
        setSize(200, 160);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btnOK = new JButton("Tekan");
        text = new TextField();
        decimal = new Label("Decimal");
        JLabel Biner = new JLabel("Biner");
        Container c = getContentPane();
        c.setLayout(new GridLayout(2,2));
        c.add(btnOK);
        c.add(text);
        c.add(decimal);
        c.add(Biner);
        btnOK.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        int x = Integer.parseInt(text.getText());
        int y = 0;
        int n = 0;
        while (true) {
            if (x == 0) {
                break;
            } else {
                int temp = x % 10;
                y += temp * Math.pow(2, n);
                x = x / 10;
                n++;
            }
        }
        decimal.setText("Decimal = "+Integer.toString(y));
    }
}
