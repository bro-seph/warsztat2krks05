package pl.coderslab.warsztat2krks05;

import pl.coderslab.warsztat2krks05.utils.DbUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        try {
            Connection conn = DbUtils.getConnection();

            System.out.println("działa!" + conn.hashCode());

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
