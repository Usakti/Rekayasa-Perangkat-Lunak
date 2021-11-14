package prak7;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class prak7 extends JFrame implements ActionListener {
    public JTextField ID, nama, alamat, email;
    DefaultTableModel model = new DefaultTableModel(new String[]{"ID","Judul","Jumlah Halaman", "Rating", "ISBN", "Tanggal Terbit"}, 0 );
    static JTable table;

    public prak7() {
        setTitle("MODUL 6 - Nadya Amanda - 064001900003");
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

        this.ID = new JTextField(16);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gb.setConstraints(ID, gbc);
        panelgb.add(ID);
        ID.addActionListener(this);

        JLabel Lnama = new JLabel("Nama Penerbit:");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gb.setConstraints(Lnama, gbc);
        panelgb.add(Lnama);

        this.nama = new JTextField(16);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gb.setConstraints(nama, gbc);
        panelgb.add(nama);
        nama.addActionListener(this::actionPerformed);

        JLabel Lalamat = new JLabel("Alamat:");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gb.setConstraints(Lalamat, gbc);
        panelgb.add(Lalamat);

        this.alamat = new JTextField(16);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gb.setConstraints(alamat, gbc);
        panelgb.add(alamat);
        alamat.addActionListener(this::actionPerformed);

        JLabel LEmail = new JLabel("Email:");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gb.setConstraints(LEmail, gbc);
        panelgb.add(LEmail);

        this.email = new JTextField(16);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 4;
        gb.setConstraints(email, gbc);
        panelgb.add(email);
        email.addActionListener(this::actionPerformed);

        panelgb.setBorder(BorderFactory.createTitledBorder("Cari Buku"));
        cp.add(panelgb);

        JPanel panelKanan = new JPanel();
        panelKanan.setLayout(gb);

        JTable table = new JTable(model);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gb.setConstraints(table, gbc);
        panelKanan.add(table);

        panelKanan.add(new JScrollPane(table));

        panelKanan.setBorder(BorderFactory.createTitledBorder("Rincian Buku"));
        cp.add(panelKanan);
    }

    public void actionPerformed (ActionEvent e){

        if(e.getSource() == ID){
            koneksi.getKoneksi(ID.getText(), "id_publisher", model, table, ID, nama, alamat, email);
        }
        if (e.getSource() == alamat ){
            koneksi.getKoneksi(alamat.getText(), "alamat", model, table, ID, nama, alamat, email);
        }
        if (e.getSource() == email){
            koneksi.getKoneksi(email.getText(), "email", model, table, ID, nama, alamat, email);
        }
        if (e.getSource() == nama) {
            koneksi.getKoneksi(nama.getText(), "nama_penerbit", model, table, ID, nama, alamat, email);
        }

        else {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan");
        }
    }

    public static void main(String[]args) {
        new prak7().setVisible(true);
    }
}

