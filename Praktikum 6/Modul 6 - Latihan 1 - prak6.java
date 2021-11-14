package prak6;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class prak6 extends JFrame {
    public JTextField ID, nama, alamat, email;
    public String text1, text2, text3, text4;

    public prak6() {
        setTitle("MODUL 6 - Nadya Amanda - 065001900001");
        addGUI();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    public void addGUI() {
        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        Container cp = getContentPane();
        cp.setLayout(gb);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel panelgb = new JPanel();
        panelgb.setLayout(gb);
        JLabel LID = new JLabel("ID Publisher:");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gb.setConstraints(LID, gbc);
        panelgb.add(LID);

        ID = new JTextField(16);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gb.setConstraints(ID, gbc);
        panelgb.add(ID);

        JLabel Lnama = new JLabel("Nama Penerbit:");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gb.setConstraints(Lnama, gbc);
        panelgb.add(Lnama);

        nama = new JTextField(16);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gb.setConstraints(nama, gbc);
        panelgb.add(nama);

        JLabel Lalamat = new JLabel("Alamat:");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gb.setConstraints(Lalamat, gbc);
        panelgb.add(Lalamat);

        alamat = new JTextField(16);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gb.setConstraints(alamat, gbc);
        panelgb.add(alamat);

        JLabel LEmail = new JLabel("Email:");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gb.setConstraints(LEmail, gbc);
        panelgb.add(LEmail);

        email = new JTextField(16);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 4;
        gb.setConstraints(email, gbc);
        panelgb.add(email);

        JButton btKirim = new JButton("Insert Data");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 3;
        gbc.gridx = 0;
        gbc.gridy = 7;
        gb.setConstraints(btKirim, gbc);
        btKirim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text1 = ID.getText();
                text2 = nama.getText();
                text3 = alamat.getText();
                text4 = email.getText();
                koneksi con = new koneksi();
                con.getKoneksi(text1, text2, text3, text4);
            }
        });
        panelgb.add(btKirim);

        panelgb.setBorder(BorderFactory.createTitledBorder("Form Input"));
        cp.add(panelgb);
    }

    public static void main(String[]args) {
        new prak6().setVisible(true);
    }
}
