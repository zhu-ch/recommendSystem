package bit.ss.recommendSystem.common.utils;

public class StringUtils {

    public static boolean isDigit(String str) {
        try {
            Double.parseDouble(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
