package services;

import java.util.UUID;

public class Utils {
    public static String generateRandomUsername() {
        return "user_" + UUID.randomUUID().toString().substring(0, 8);
    }

    public static String generateRandomPassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            int index = (int) (Math.random() * characters.length());
            password.append(characters.charAt(index));
        }
        return password.toString();
    }
}