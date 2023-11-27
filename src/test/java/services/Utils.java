package services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.UUID;

public class Utils {

    public static String username = generateRandomUsername();
    public static String password = generateRandomPassword();

    private static Utils util;

    private Utils() {
        // private constructor to prevent instantiation
    }

    public static Utils getService() {
        if (util == null) {
            util = new Utils();
        }
        return util;
    }

    public static String generateRandomUsername() {
        username = "user_" + UUID.randomUUID().toString().substring(0, 8);
        return username;
    }

    public static String generateRandomPassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
        StringBuilder p = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            int index = (int) (Math.random() * characters.length());
            p.append(characters.charAt(index));
        }
        password = p.toString();
        return password;
    }

    public static String getUsername(){
        return username;
    }

    public static String getPassword(){
        return password;
    }

}