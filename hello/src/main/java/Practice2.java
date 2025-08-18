import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Practice2 {
    public static void main(String[] args) {
        String testStr1 = null;
        String testStr2 = "";
        String testStr3 = "hi";

        System.out.println("Objects.isNull , 'java.lang.String.isEmpty()' 활용");
        System.out.println("null = " + isNullOrEmpty(testStr1));
        System.out.println("\"\" = " +isNullOrEmpty(testStr2));
        System.out.println("hi = " +isNullOrEmpty(testStr3));


        System.out.println("`org.apache.commons.lang3.StringUtils.isEmpty()`를 이용한 empty 체크");
        System.out.println("null = " + StringUtils.isEmpty(testStr1));
        System.out.println("\"\" = " +StringUtils.isEmpty(testStr2));
        System.out.println("hi = " +StringUtils.isEmpty(testStr3));


    }

    public static boolean isNullOrEmpty(String string) {
        if (Objects.isNull(string) || string.isEmpty()) {
            return true;
        }
        return false;
    }

}
