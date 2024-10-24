package org.example;
import org.services.UserServices;


public class Main extends UserServices{
    public static void main(String[] args) {
        UserServices userService = new UserServices("john_doe", "securepassword", "john@example.com");
        userService.DBConnect();
        userService.Login();

    }
}