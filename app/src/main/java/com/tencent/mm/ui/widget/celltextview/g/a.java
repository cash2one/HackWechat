package com.tencent.mm.ui.widget.celltextview.g;

import android.graphics.Paint;
import android.graphics.Rect;
import java.util.regex.Pattern;

public final class a {
    static Pattern yyy = Pattern.compile("[`\"~!@#$^&*()=|{}':;',\\[\\].<>/?～！@#￥……&*（）——|{}【】‘；：”“'。，、？「」]$");
    private static Rect zxW = new Rect();

    public static boolean q(char c) {
        return (c >= 'a' && c <= 'z') || ((c >= 'A' && c <= 'Z') || ((c >= '0' && c <= '9') || c == '_' || c == '-' || c == '@'));
    }

    public static boolean r(char c) {
        if (c == '、' || c == '）' || c == '，' || c == '。' || c == '》' || c == '】' || c == '」' || c == '？' || c == '；' || c == '：' || c == '”') {
            return true;
        }
        return false;
    }

    public static boolean s(char c) {
        if (c == '（' || c == '《' || c == '「' || c == '【' || c == '“') {
            return true;
        }
        return false;
    }

    public static int dx(String str, int i) {
        while (i >= 0) {
            if (!q(str.charAt(i))) {
                return i + 1;
            }
            i--;
        }
        return 0;
    }

    public static int dy(String str, int i) {
        while (i >= 0) {
            if (!t(str.charAt(i))) {
                return i + 1;
            }
            i--;
        }
        return 0;
    }

    public static int dz(String str, int i) {
        while (i < str.length()) {
            if (!t(str.charAt(i))) {
                return i - 1;
            }
            i++;
        }
        return i - 1;
    }

    public static char dv(String str, int i) {
        if (i < 0 || str == null || i >= str.length()) {
            return '\u0000';
        }
        return str.charAt(i);
    }

    public static char[] ag(String str, int i, int i2) {
        int i3 = i2 - i;
        if (str == null || i < 0 || i > i2) {
            return new char[i3];
        }
        char[] cArr = new char[i3];
        if (i2 > str.length()) {
            i2 = str.length();
        }
        str.getChars(i, i2, cArr, 0);
        return cArr;
    }

    public static boolean t(char c) {
        return yyy.matcher(Character.toString(c)).find();
    }

    public static float a(char c, Paint paint) {
        String valueOf = String.valueOf(c);
        float measureText = paint.measureText(valueOf);
        paint.getTextBounds(valueOf, 0, 1, zxW);
        int i = (int) (measureText - ((float) zxW.right));
        return i > 0 ? (float) i : 0.0f;
    }

    public static float b(char c, Paint paint) {
        paint.getTextBounds(String.valueOf(c), 0, 1, zxW);
        int i = zxW.left;
        return i > 0 ? (float) i : 0.0f;
    }
}
