package utils;

import org.junit.Test;

import java.security.MessageDigest;

public class MD5Utils {
    public static String md5Code(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test() {
        String str = "Welcome";
        String res = md5Code(str);
        System.out.println(res);
    }
}
