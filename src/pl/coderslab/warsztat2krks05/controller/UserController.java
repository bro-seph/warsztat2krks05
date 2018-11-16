package pl.coderslab.warsztat2krks05.controller;

import pl.coderslab.warsztat2krks05.model.User;
import pl.coderslab.warsztat2krks05.utils.DbUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class UserController {
    public static void main(String[] args) {
        System.out.println("Welcome to user administration panel");
        System.out.println("Select option and hit enter. Options: ");
        System.out.println("1 - Add");
        System.out.println("2 - Edit");
        System.out.println("3 - Delete");
        System.out.println("0 - Quit");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine(); //pobieramy inputa najpierw
        while (true) { //pętla nieskończona ale kończymy gdy jest 0 bo jest break
            if (input.equals("0")) {
                break;
            } else if (input.equals("1")) {
                addUser();
            } else if (input.equals("2")) {
                editUser();
            } else if (input.equals("3")) {
                deleteUser();
            } else {
                System.out.println("Provide a proper menu option");
                System.out.println("Select option and hit enter. Options: ");
            }
            input = scanner.nextLine(); //

        }
        System.out.println("Program has ended!");
    }

    private static void deleteUser() {
        // TODO
    }

    private static void editUser() {
        //TODO
    }

    private static void addUser() {
        try {


            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter username");
            final String username = scanner.nextLine();

            System.out.println("Enter email");
            final String email = scanner.nextLine();

            System.out.println("Enter password");
            final String password = scanner.nextLine();
            User u = new User(username, email, password);
            Connection conn = DbUtils.getConnection();
            u.saveToDB(conn);
            conn.close();
            System.out.println("User saved");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
