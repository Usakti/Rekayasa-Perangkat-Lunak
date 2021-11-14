package prak7;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class koneksi {
    private static Connection koneksi = null;
    public static Connection getKoneksi(String val, String column, DefaultTableModel model, JTable table, JTextField id, JTextField nama, JTextField alamat, JTextField email) {
        try {
            String url = "jdbc:mysql://localhost:3306/prak6?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String user = "root";
            String pass = "";

            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            koneksi = DriverManager.getConnection(url, user, pass);
            Statement state = (Statement) koneksi.createStatement();

            ResultSet td = state.executeQuery("SELECT * FROM publisher WHERE " +column+ " LIKE '%" +val+ "%'");

            if(td.next()) {
                String idp = td.getString("id_publisher");
                String namap = td.getString("nama_penerbit");
                String alamatp = td.getString("alamat");
                String emailp = td.getString("email");
                id.setText(idp);
                nama.setText(namap);
                alamat.setText(alamatp);
                email.setText(emailp);

                column = "id_publisher";
                val = idp;
            } else {
                JOptionPane.showMessageDialog(null, "Buku Tidak Ada!");
            }

            ResultSet rs = state.executeQuery("SELECT * FROM buku LEFT JOIN publisher ON " +
                    "buku.id_publisher = publisher.id_publisher WHERE publisher." +column+ " LIKE " +val+ "");
            while(rs.next()) {
                String d = rs.getString("id_buku");
                String e = rs.getString("judul");
                String f = rs.getString("jml_halaman");
                String g = rs.getString("rating");
                String h = rs.getString("isbn");
                String i = rs.getString("tgl_terbit");
                model.addRow(new Object[]{d, e, f, g, h, i});
            }
            prak7.table.setModel(model);

            koneksi.close();

        } catch (SQLException t) {
            System.out.print(t);
        }

        return koneksi;
    }
}
