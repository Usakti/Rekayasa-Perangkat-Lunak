import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

class Prak4 extends JFrame implements ActionListener {
    JLabel Judul;
    JComboBox<String> makanan;
    JCheckBox lemon, air, jus;
    JRadioButton makanDiTempat, BawaPulang;
    JButton pesanBtn;
    int hrgmakanan, total;
    int hrgminum = 0;
    String str_makanan1, str_makanan2, str_makanan3;
    String[] harga1, harga2, harga3;
    String str_harga1, str_harga2, str_harga3;
    String str_menu, str_minum, str_tempat, laporan;

    public Prak4() throws FileNotFoundException, NullPointerException {
        Scanner scanner = new Scanner(new File("src/jenis_makanan.txt"));
        str_makanan1 = scanner.nextLine();
        str_makanan2 = scanner.nextLine();
        str_makanan3 = scanner.nextLine();

        harga1 = str_makanan1.split("Rp");
        harga2 = str_makanan2.split("Rp");
        harga3 = str_makanan3.split("Rp");

        str_harga1 = harga1[1];
        str_harga2 = harga2[1];
        str_harga3 = harga3[1];

        String[] stringmakanan = {str_makanan1, str_makanan2, str_makanan3};
        setTitle("Menu Makanan");
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        int dh = d.height;
        int dw = d.width;
        setLocation(dw/4, dh/4);
        setSize(500, 300);

        Judul = new JLabel("Nadya Amanda - 064001900003", SwingConstants.LEFT);

        pesanBtn = new JButton("Pesan");
        pesanBtn.addActionListener(this);

        makanan = new JComboBox<String>(stringmakanan);
        makanan.setSelectedIndex(0);

        lemon = new JCheckBox("Lemon");
        air = new JCheckBox("Air Mineral");
        jus = new JCheckBox("Jus");

        makanDiTempat = new JRadioButton("Makan Di Tempat");
        BawaPulang = new JRadioButton("Dibungkus dan Dibawa Pulang");
        ButtonGroup bg = new ButtonGroup();
        bg.add(makanDiTempat);
        bg.add(BawaPulang);

        Font font = new Font("Tahoma", Font.BOLD, 16);
        Judul.setFont(font);

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        p1.setLayout(new GridLayout(2, 1));
        p2.setLayout(new FlowLayout());

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        p3.setLayout(gbl);
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weighty = 1;
        p3.add(air, c);

        c.gridx = 0;
        c.gridy = 1;
        p3.add(lemon, c);

        c.gridx = 0;
        c.gridy = 2;
        p3.add(jus, c);

        p1.add(makanan);
        p2.add(makanDiTempat);
        p2.add(BawaPulang);
        p1.add(p2);

        Container cp = getContentPane();
        cp.add(Judul, BorderLayout.NORTH);
        cp.add(p1, BorderLayout.CENTER);
        cp.add(p3, BorderLayout.EAST);
        cp.add(pesanBtn, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent event) {
        pesanan();
        total = hrgmakanan + hrgminum;
        laporan = "Pesanan = " + str_menu + " | Minuman = " + str_minum + " | Harga Total = " + total + " || " + str_tempat;
        if (event.getSource().equals(pesanBtn)) {
            JOptionPane.showMessageDialog(null, laporan);
            hrgminum = 0;
            total = 0;
        }
    }

    public void pesanan() {
        if (makanan.getSelectedIndex() == 0) {
            hrgmakanan = Integer.parseInt(str_harga1);
            str_menu = str_makanan1;
        } else if (makanan.getSelectedIndex() == 1) {
            hrgmakanan = Integer.parseInt(str_harga2);
            str_menu = str_makanan2;
        } else if (makanan.getSelectedIndex() == 2) {
            hrgmakanan = Integer.parseInt(str_harga3);
            str_menu = str_makanan3;
        } else {
            hrgmakanan = 0;
            str_menu = "Anda tidak memilih pesanan";
        }
        if (air.isSelected()) {
            hrgminum += 3000;
            str_minum = "Air";
        }
        if (lemon.isSelected()) {
            hrgminum += 5000;
            str_minum = "Lemon";
        }
        if (jus.isSelected()) {
            hrgminum += 5000;
            str_minum = "Jus";
        }
        if (makanDiTempat.isSelected()) {
            str_tempat = "Makan Ditempat";
        }
        if (BawaPulang.isSelected()) {
            str_tempat = "Dibungkus dan Dibawa";
        }
    }
}

class Jalankan {
    public static void main (String[] args) throws FileNotFoundException, NullPointerException {
        JFrame nadya = new Prak4();
        nadya.setVisible(true);
    }
}
