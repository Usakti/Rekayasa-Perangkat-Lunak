package prak8;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class koneksi {
    private static Connection koneksi = null;

    public static Connection getKoneksi(String val, String column, DefaultTableModel model, JTable table, JTextField id, JTextField namad, JTextField namat, JTextField namab) {
        try {
            String url = "jdbc:mysql://localhost:3306/prak6?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String user = "root";
            String pass = "";

            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            koneksi = DriverManager.getConnection(url, user, pass);
            Statement state = (Statement) koneksi.createStatement();

            ResultSet td = state.executeQuery("SELECT * FROM author WHERE " + column + " LIKE '%" + val + "%'");

            if (td.next()) {
                String idp = td.getString("id_author");
                String namadp = td.getString("nama_depan");
                String namatp = td.getString("nama_tengah");
                String namabp = td.getString("nama_belakang");
                id.setText(idp);
                namad.setText(namadp);
                namat.setText(namatp);
                namab.setText(namabp);

                column = "id_author";
                val = idp;
            } else {
                JOptionPane.showMessageDialog(null, "Buku Tidak Ada!");
            }

            ResultSet rs = state.executeQuery("SELECT * FROM buku LEFT JOIN book_author ON " +
                    "buku.id_buku = book_author.book_id RIGHT JOIN author ON " +
                    "book_author.author_id = author.id_author WHERE author." + column + " LIKE " + val + "");
            while (rs.next()) {
                String d = rs.getString("id_buku");
                String e = rs.getString("judul");
                String f = rs.getString("jml_halaman");
                String g = rs.getString("rating");
                String h = rs.getString("isbn");
                String i = rs.getString("tgl_terbit");
                model.addRow(new Object[]{d, e, f, g, h, i});
            }
            prak8.table.setModel(model);

            koneksi.close();

        } catch (SQLException t) {
            System.out.print(t);
        }

        return koneksi;
    }
}
