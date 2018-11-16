package pl.coderslab.warsztat2krks05;

import pl.coderslab.warsztat2krks05.model.User;
import pl.coderslab.warsztat2krks05.utils.DbUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {


        try {
            Connection conn = DbUtils.getConnection();
            User u = new User("Ala", "ala@mail.pl", "ala");
            u.saveToDB(conn);
            System.out.println("id: " + u.getId());
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
