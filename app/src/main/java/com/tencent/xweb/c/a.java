package com.tencent.xweb.c;

import android.os.Build;
import android.os.Build.VERSION;
import java.util.regex.Pattern;
import org.xwalk.core.XWalkEnvironment;

public final class a {

    public static class b {
        public int AqO = -1;
        public int AqP = -1;
        public int AqQ = -1;
        public int AqR = -1;
        public int AqS = -1;
        public int AqT = -1;
        public String AqU = "";
        public int AqV = -1;
        public int AqW = -1;

        public final boolean cIA() {
            if (ao(XWalkEnvironment.getAvailableVersion(), this.AqQ, this.AqR) && ao(17, this.AqO, this.AqP) && ao(VERSION.SDK_INT, this.AqS, this.AqT) && ao(XWalkEnvironment.getGrayValue(), this.AqV, this.AqW)) {
                String str = this.AqU;
                CharSequence charSequence = "";
                new StringBuilder().append(Build.BRAND).append(" ").append(Build.MODEL);
                if (Build.BRAND != null) {
                    charSequence = charSequence + Build.BRAND;
                }
                if (Build.MODEL != null) {
                    charSequence = charSequence + " " + Build.MODEL;
                }
                boolean find = (str == null || charSequence == null || str.isEmpty()) ? false : Pattern.compile(str).matcher(charSequence).find();
                if (!find) {
                    return true;
                }
            }
            return false;
        }

        private static boolean ao(int i, int i2, int i3) {
            if (i3 > 0 && i > i3) {
                return false;
            }
            if (i2 <= 0 || i >= i2) {
                return true;
            }
            return false;
        }
    }
}
