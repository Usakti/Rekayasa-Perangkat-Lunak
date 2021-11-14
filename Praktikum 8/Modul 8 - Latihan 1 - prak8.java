package prak8;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class prak8 extends JFrame implements ActionListener {
    public JTextField ID, namad, namat, namab;
    DefaultTableModel model = new DefaultTableModel(new String[]{"ID","Judul","Jumlah Halaman", "Rating", "ISBN", "Tanggal Terbit"}, 0 );
    static JTable table;

    public prak8() {
        setTitle("MODUL 8 - Nadya Amanda - 064001900003");
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
        JLabel LID = new JLabel("ID Author:");
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

        JLabel Lnamad = new JLabel("Nama Depan:");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gb.setConstraints(Lnamad, gbc);
        panelgb.add(Lnamad);

        this.namad = new JTextField(16);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gb.setConstraints(namad, gbc);
        panelgb.add(namad);
        namad.addActionListener(this::actionPerformed);

        JLabel Lnamat = new JLabel("Nama Tengah:");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gb.setConstraints(Lnamat, gbc);
        panelgb.add(Lnamat);

        this.namat = new JTextField(16);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gb.setConstraints(namat, gbc);
        panelgb.add(namat);
        namat.addActionListener(this::actionPerformed);

        JLabel Lnamab = new JLabel("Nama Belakang:");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gb.setConstraints(Lnamab, gbc);
        panelgb.add(Lnamab);

        this.namab = new JTextField(16);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 4;
        gb.setConstraints(namab, gbc);
        panelgb.add(namab);
        namab.addActionListener(this::actionPerformed);

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
            koneksi.getKoneksi(ID.getText(), "id_author", model, table, ID, namad, namat, namab);
        }
        if (e.getSource() == namad){
            koneksi.getKoneksi(namad.getText(), "nama_depan", model, table, ID, namad, namat, namab);
        }
        if (e.getSource() == namat){
            koneksi.getKoneksi(namat.getText(), "nama_tengah", model, table, ID, namad, namat, namab);
        }
        if (e.getSource() == namab) {
            koneksi.getKoneksi(namab.getText(), "nama_belakang", model, table, ID, namad, namat, namab);
        }

        else {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan");
        }
    }

    public static void main(String[]args) {
        new prak8().setVisible(true);
    }
}


