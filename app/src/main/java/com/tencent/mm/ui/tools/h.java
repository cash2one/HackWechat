package com.tencent.mm.ui.tools;

import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class h implements InputFilter {
    private int jXV;
    private int jXW;

    public enum a {
        ;

        static {
            zkT = 1;
            zkU = 2;
            zkV = new int[]{zkT, zkU};
        }
    }

    public h(int i, int i2) {
        this.jXV = i;
        this.jXW = i2;
    }

    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        if (du(spanned.toString(), this.jXW) + du(charSequence.toString(), this.jXW) > this.jXV) {
            return "";
        }
        return charSequence;
    }

    public static int du(String str, int i) {
        if (i == a.zkT) {
            if (bh.ov(str)) {
                return 0;
            }
            return str.length();
        } else if (i == a.zkU) {
            return ZY(str);
        } else {
            return 0;
        }
    }

    public static int ZY(String str) {
        int i = 0;
        if (bh.ov(str)) {
            return 0;
        }
        int ZZ = ZZ(str) + str.length();
        if (!bh.ov(str)) {
            int i2 = 0;
            while (i < str.length()) {
                char charAt = str.charAt(i);
                if (charAt >= '\u0000' && charAt <= '') {
                    i2++;
                }
                i++;
            }
            i = str.length() - (i2 + ZZ(str));
        }
        return i + ZZ;
    }

    public static int ZZ(String str) {
        if (bh.ov(str)) {
            return 0;
        }
        Matcher matcher = Pattern.compile("[\\u4e00-\\u9fa5]").matcher(str);
        int i = 0;
        while (matcher.find()) {
            int i2 = 0;
            while (i2 <= matcher.groupCount()) {
                i2++;
                i++;
            }
        }
        return i;
    }

    public static int aY(int i, String str) {
        if (w.cfe()) {
            return Math.round(((float) (i - Math.round((float) ZY(str)))) / 2.0f);
        }
        return i - ZY(str);
    }

    public static int aZ(int i, String str) {
        if (w.cfe()) {
            return Math.round(((float) (Math.round((float) ZY(str)) - i)) / 2.0f);
        }
        return ZY(str) - i;
    }
}
