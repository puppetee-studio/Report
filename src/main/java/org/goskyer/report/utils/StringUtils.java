package org.goskyer.report.utils;

public class StringUtils {

    public static boolean compare(String a1, String a2) {

        if (a1 == null || a2 == null) throw new NullPointerException();

        return a1.equals(a2);
    }

}
