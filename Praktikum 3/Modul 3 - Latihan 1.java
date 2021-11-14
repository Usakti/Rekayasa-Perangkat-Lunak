import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Prak3 extends JFrame {
    private JTextField nama, alamat, notelp, email;
    private String JenisKel = "Laki-Laki";
    private JPasswordField pass, confirmpass;

    public Prak3() {
        setTitle("Aplikasi Formulir Nadya Amanda - 064001900003");
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

        JLabel Jkl = new JLabel("Pilih Jenis Kelamin:");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gb.setConstraints(Jkl, gbc);
        panelgb.add(Jkl);

        JRadioButton rbL = new JRadioButton("Laki-Laki", true);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gb.setConstraints(rbL, gbc);
        panelgb.add(rbL);
        rbL.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JenisKel = "Laki-Laki";
            }
        });

        JRadioButton rbP = new JRadioButton("Perempuan", true);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 2;
        gbc.gridy = 1;
        gb.setConstraints(rbP, gbc);
        panelgb.add(rbP);
        rbP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JenisKel = "Perempuan";
            }
        });

        ButtonGroup btnGp = new ButtonGroup();
        btnGp.add(rbL);
        btnGp.add(rbP);

        JLabel LAlamat = new JLabel("Alamat:");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gb.setConstraints(LAlamat, gbc);
        panelgb.add(LAlamat);

        alamat = new JTextField(16);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gb.setConstraints(alamat, gbc);
        panelgb.add(alamat);

        JLabel LNo = new JLabel("Nomor Telepon:");
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

        JLabel LPass = new JLabel("Password:");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 5;
        gb.setConstraints(LPass, gbc);
        panelgb.add(LPass);

        pass = new JPasswordField(16);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 5;
        gb.setConstraints(pass, gbc);
        panelgb.add(pass);

        JLabel LCp = new JLabel("Konfirmasi Password:");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 6;
        gb.setConstraints(LCp, gbc);
        panelgb.add(LCp);

        confirmpass = new JPasswordField(16);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 6;
        gb.setConstraints(confirmpass, gbc);
        panelgb.add(confirmpass);

        JButton btKirim = new JButton("Kirim");
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
                String regPassword = new String (pass.getPassword());
                String retPassword = new String (confirmpass.getPassword());
                if (regPassword.equals(retPassword)) {
                    JOptionPane.showMessageDialog(null, "Nama: "+ nama.getText() + "\nJenis Kelamin: " + JenisKel + "\nAlamat: " + alamat.getText() + "\nNo Telepon: " + notelp.getText() + "\nEmail: " + email.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "Password Tidak Sesuai");
                }
            }
        });
        panelgb.add(btKirim);

        panelgb.setBorder(BorderFactory.createTitledBorder("Program Pengisian Form"));
        cp.add(panelgb);
    }

    public static void main(String[]args) {
        new Prak3().setVisible(true);
    }
}
