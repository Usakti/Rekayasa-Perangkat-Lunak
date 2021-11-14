package prak6;

import java.sql.*;
import javax.swing.*;

public class koneksi {
    private static Connection koneksi = null;
    public static Connection getKoneksi(String text1, String text2, String text3, String text4) {
        try {
            String url = "jdbc:mysql://localhost:3306/prak6?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String user = "root";
            String pass = "";

            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            koneksi = DriverManager.getConnection(url, user, pass);
            Statement state = (Statement) koneksi.createStatement();

            state.executeUpdate("INSERT INTO publisher (id_publisher, nama_penerbit, alamat, email) VALUES ('"+text1+"', '"+text2+"', '"+text3+"', '"+text4+"')");
            koneksi.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil dimasukkan kedalam Tabel Publisher");
        } catch (SQLException t) {
            System.out.print(t);
        }
        return koneksi;
    }
}
