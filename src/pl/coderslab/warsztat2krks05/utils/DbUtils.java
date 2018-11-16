package pl.coderslab.warsztat2krks05.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {
    public static Connection getConnection() throws SQLException { //wyrzucić wyjątek na zewnątrz żeby osoba używająca klasy mogła zobaczyć przyczynę

        Connection conn = DriverManager

        .getConnection("jdbc:mysql://localhost:3306/warsztat2krks05?useSSL=false",
                "root", "coderslab");

        return conn;
    }
}
