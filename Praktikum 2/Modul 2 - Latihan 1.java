import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.sql.Date;

public class prak2 {
    public static void main(String[] args) {
        GUI frame = new GUI();
        frame.setVisible(true);

    }

}

class GUI extends JFrame implements ActionListener{
    private JTextField jtN;
    private JComboBox jcM;
    private JLabel atas, tengah;
    private JRadioButton rbAir, rbEsT;
    private JButton msg;
    int hrgMkn = 15000, hrgMnm = 1000;
    String Minuman = "Air Putih";

    GUI(){
        setTitle("prak2 Nadya Amanda - 0640001900003");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cp = getContentPane();

        JPanel panelAtas = new JPanel(new FlowLayout());
        JPanel panelTengah = new JPanel(new FlowLayout());
        JPanel panelBawah = new JPanel(new FlowLayout());

        Border border = BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(),"Nadya Cafe", 2,1);
        panelAtas.setBorder(border);

        atas = new JLabel("Nama:");
        tengah = new JLabel("Makanan:");
        panelAtas.add(atas);
        panelTengah.add(tengah);

        String[] makanan = {"Waffle", "Cup Cake"};
        jtN = new JTextField();
        jcM = new JComboBox(makanan);
        jtN.setColumns(15);
        jcM.setSize(15,5);
        panelAtas.add(jtN);
        panelTengah.add(jcM);

        rbEsT = new JRadioButton("Peach Gum", true);
        rbAir = new JRadioButton("Boba", true);
        rbEsT.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Minuman = "Peach Gum";
                hrgMnm = 17000;
            }
        });

        rbAir.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Minuman = "Boba";
                hrgMnm = 15000;
            }
        });

        jcM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String y = jcM.getSelectedItem().toString();
                if (y.equals("Waffle")){
                    hrgMkn = 20000;
                }
                else{
                    hrgMkn =10000;
                }
            }
        });

        ButtonGroup bntGrp = new ButtonGroup();
        bntGrp.add(rbAir);
        bntGrp.add(rbEsT);
        panelBawah.add(rbAir);
        panelBawah.add(rbEsT);

        msg = new JButton("Order");
        msg.addActionListener(this);
        panelBawah.add(msg);


        cp.add(panelAtas, BorderLayout.NORTH);
        cp.add(panelTengah,BorderLayout.CENTER);
        cp.add(panelBawah, BorderLayout.SOUTH);
        pack();
    }

    public void actionPerformed (ActionEvent e){
        JOptionPane.showMessageDialog(null,
                "|-------------------------------|\n" +
                        "|          Nadya Cafe           |\n"+
                        "|-------------------------------|\n"+
                        "| Nama    : "+jtN.getText() +"      |\n"+
                        "| Makanan : "+jcM.getSelectedItem().toString() +"      |\n"+
                        "| Minuman : "+ Minuman +"      |\n"+
                        "|-------------------------------|\n" +
                        "| "+jcM.getSelectedItem()+" : "+ String.valueOf(hrgMkn)+"      |\n"+
                        "| "+Minuman+" : "+ String.valueOf(hrgMnm)+"      |\n"+
                        "|-------------------------------|\n"+
                        "| Total : "+ String.valueOf(hrgMnm+hrgMkn)+"      |\n"


        );
    }
}
