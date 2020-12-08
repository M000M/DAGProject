package utils;

public class MD5Utils {
    public static String md5Code(String value) {
        return String.valueOf(value.hashCode());
    }
}
