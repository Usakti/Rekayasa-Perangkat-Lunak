package prak5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Prak5 extends JFrame {
    public JTextField nama, ttl, notelp, email;
    public String text1, text2, text3, text4;

    public Prak5() {
        setTitle("Koneksi Database Nadya Amanda - 064001900003");
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
        JLabel LNama = new JLabel("Nama:");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gb.setConstraints(LNama, gbc);
        panelgb.add(LNama);

        nama = new JTextField(16);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gb.setConstraints(nama, gbc);
        panelgb.add(nama);

        JLabel LTTL = new JLabel("Tempat Tanggal Lahir:");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gb.setConstraints(LTTL, gbc);
        panelgb.add(LTTL);

        ttl = new JTextField(16);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gb.setConstraints(ttl, gbc);
        panelgb.add(ttl);

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

        JLabel LNo = new JLabel("No Whatsapp:");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gb.setConstraints(LNo, gbc);
        panelgb.add(LNo);

        notelp = new JTextField(16);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gb.setConstraints(notelp, gbc);
        panelgb.add(notelp);

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
                text1 = nama.getText();
                text2 = ttl.getText();
                text3 = notelp.getText();
                text4 = email.getText();
                koneksidata con = new koneksidata();
                con.getKoneksi(text1, text2, text3, text4);
            }
        });
        panelgb.add(btKirim);

        panelgb.setBorder(BorderFactory.createTitledBorder("Form Input"));
        cp.add(panelgb);
    }

    public static void main(String[]args) {
        new Prak5().setVisible(true);
    }
}
