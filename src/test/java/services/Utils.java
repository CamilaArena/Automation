package services;

import java.util.UUID;

public class Utils {

    public static String username;
    public static String password;
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