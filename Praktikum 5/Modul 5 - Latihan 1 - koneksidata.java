package prak5;

import java.sql.*;
import javax.swing.*;

public class koneksidata {
    private static Connection koneksi = null;
    public static Connection getKoneksi(String text1, String text2, String text3, String text4) {
        try {
            String url = "jdbc:mysql://localhost:3306/prak5?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String user = "root";
            String pass = "";

            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            koneksi = DriverManager.getConnection(url, user, pass);
            Statement state = (Statement) koneksi.createStatement();

            state.executeUpdate("INSERT INTO biodata (nama, ttl, email, notelp) VALUES ('"+text1+"', '"+text2+"', '"+text4+"', '"+text3+"')");
            koneksi.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil dimasukkan kedalam Tabel Biodata");
        } catch (SQLException t) {
            System.out.print(t);
        }
        return koneksi;
    }
}
