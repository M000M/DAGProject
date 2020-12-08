package utils;

public class SHA1Utils {
    public static String sha1Code(String value) {
        return String.valueOf(value.hashCode());
    }
}
