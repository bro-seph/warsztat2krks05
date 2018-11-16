package pl.coderslab.warsztat2krks05.model;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private int id;
    private String username;
    private String email;
    private String password;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        setPassword(password); // ustawiono wywołanie metody (nie możemy przechowywać niezaszyfrowanego hasła
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isPasswordCorrect(String candidate) {
        return BCrypt.checkpw(candidate, this.password);
    }

    public void setPassword(String password) {
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    // nie statyczna bo ma korzystać z obecnego stanu obiektu
    public void saveToDB(Connection conn)
            throws SQLException {
        if (this.id == 0) {
            final String sql = "INSERT INTO users (username, email, password) " +
                    "VALUES (?, ?, ?);";

            String[] generatedValues = {"id"};


            PreparedStatement ps = conn.prepareStatement(sql, generatedValues); //prepareStatement zwraca instancje klasy prepared statement
            ps.setString(1, this.username);
            ps.setString(2, this.email);
            ps.setString(3, this.password);

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) { //ponieważ wiemy że jeden rekord wygenerował to wystarczy if a nie pętla while
                this.id = rs.getInt(1);

            }
            rs.close();
            ps.close();
        } else {
            //TODO update db
            throw new SQLException("Not implemented!");
        }

    }
}
