package org.b.g;

import java.util.regex.Pattern;

public final class d {
    private static final Pattern AyU = Pattern.compile("^[a-zA-Z][a-zA-Z0-9+.-]*://\\S+");

    public static void j(Object obj, String str) {
        p(obj != null, str);
    }

    public static void go(String str, String str2) {
        boolean z = (str == null || str.trim().equals("")) ? false : true;
        p(z, str2);
    }

    private static void p(boolean z, String str) {
        if (str == null || str.trim().length() <= 0) {
            str = "Received an invalid parameter";
        }
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }
}
