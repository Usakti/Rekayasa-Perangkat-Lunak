import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Convert {
    public static void main(String[] args) {
        JFrame w = new frameConvert();
        w.setVisible(true);
    }
}

class frameConvert extends JFrame implements ActionListener{;
    public TextField text;
    public boolean convert = true;
    public Label biner, decimal;
    frameConvert(){
        setTitle("Prak1 - Nadya Amanda - 064001900003");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("Convert");
        text = new TextField();
        biner = new Label("Biner");
        decimal = new Label("Decimal");

        Container c = getContentPane();

        JRadioButton rbD2B = new JRadioButton("Decimal to Biner", true);
        rbD2B.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convert = true;
            }
        });

        JRadioButton rbB2D = new JRadioButton("Biner to Decimal", true);
        rbB2D.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convert = false;
            }
        });

        c.setLayout(new GridLayout(3,3));
        c.add(text);
        c.add(decimal);
        c.add(button);
        c.add(biner);
        c.add(rbB2D);
        c.add(rbD2B);
        ButtonGroup btnGp = new ButtonGroup();
        btnGp.add(rbB2D);
        btnGp.add(rbD2B);
        button.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        if (convert) {
            int n = Integer.parseInt(text.getText()), count = 0, a;
            String x = "";
            while (true) {
                if (n == 0) {
                    break;
                } else {
                    a = n % 2;
                    if (a == 1) {
                        count++;
                    }
                    x = a + "" + x;
                    n = n / 2;
                }
            }
            biner.setText("Biner = " + String.valueOf(x));
            decimal.setText("Decimal");
        } else {
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
            decimal.setText("Decimal = " + Integer.toString(y));
            biner.setText("Biner");
        }
    }
}
