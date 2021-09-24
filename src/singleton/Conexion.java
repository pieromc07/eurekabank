package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static Connection cn = null;

    private static String url = "jdbc:mysql://localhost:3306/eurekabank?useSSL=false";
    private static String user = "root";
    private static String password = "";

    private Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConexion() {

        if (cn == null) {
            new Conexion();
        }
        return cn;
    }
}
