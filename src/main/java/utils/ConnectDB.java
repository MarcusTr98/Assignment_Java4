package utils;

import java.sql.*;

public class ConnectDB {
    public static Connection con = null;

    public static Connection getConnect() {
        String strDbUrl = "jdbc:sqlserver://localhost:1433;databaseName=qlban;user=sa;password=123;encrypt=true;trustServerCertificate=true";
        try {
            // Đăng ký driver JDBC
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            con = DriverManager.getConnection(strDbUrl);
            System.out.println("Ket Noi Thanh Cong");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Connect Loi: " + e);
        }
        return con;
    }

    public static void main(String[] args) {
        getConnect();
    }
}

