package utils;

public class StringUtils
{
    /**
     * @author 'U Mad' @ https://stackoverflow.com/a/19269363
     * @param str String with multiple lines to trim
     * @return a trimmed string with multiple lines
     */
    public static String trimEachLine(String str) {
        return str.replaceAll("(?m)^[\\s&&[^\\n]]+|[\\s+&&[^\\n]]+$", "");
    }
}
