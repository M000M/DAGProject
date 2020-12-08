package utils;

public class SHA256Utils {

    public static String sha256Code(String value) {
        return String.valueOf(value.hashCode());
    }
}
