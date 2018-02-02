package com.google.android.gms.c;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class x {
    private static final Pattern aXO = Pattern.compile("\\\\.");
    private static final Pattern aXP = Pattern.compile("[\\\\\"/\b\f\n\r\t]");

    public static String aY(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Matcher matcher = aXP.matcher(str);
        StringBuffer stringBuffer = null;
        while (matcher.find()) {
            if (stringBuffer == null) {
                stringBuffer = new StringBuffer();
            }
            switch (matcher.group().charAt(0)) {
                case '\b':
                    matcher.appendReplacement(stringBuffer, "\\\\b");
                    break;
                case '\t':
                    matcher.appendReplacement(stringBuffer, "\\\\t");
                    break;
                case '\n':
                    matcher.appendReplacement(stringBuffer, "\\\\n");
                    break;
                case '\f':
                    matcher.appendReplacement(stringBuffer, "\\\\f");
                    break;
                case '\r':
                    matcher.appendReplacement(stringBuffer, "\\\\r");
                    break;
                case '\"':
                    matcher.appendReplacement(stringBuffer, "\\\\\\\"");
                    break;
                case '/':
                    matcher.appendReplacement(stringBuffer, "\\\\/");
                    break;
                case '\\':
                    matcher.appendReplacement(stringBuffer, "\\\\\\\\");
                    break;
                default:
                    break;
            }
        }
        if (stringBuffer == null) {
            return str;
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }
}
