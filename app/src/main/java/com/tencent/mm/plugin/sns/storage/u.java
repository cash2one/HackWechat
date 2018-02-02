package com.tencent.mm.plugin.sns.storage;

import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;

public final class u {
    public static String ab(String str, long j) {
        return str + j;
    }

    public static String ac(String str, long j) {
        return str + j;
    }

    public static boolean LE(String str) {
        return str != null && str.startsWith("ad_table_");
    }

    public static boolean Jv(String str) {
        return str != null && str.startsWith("sns_table_");
    }

    public static long LF(String str) {
        if (bh.ov(str)) {
            return 0;
        }
        if (str.startsWith("ad_table_")) {
            return bh.VJ(str.substring(9));
        }
        if (str.startsWith("sns_table_")) {
            return bh.VJ(str.substring(10));
        }
        return bh.VJ(str);
    }

    public static int LG(String str) {
        if (bh.ov(str)) {
            return 0;
        }
        if (str.startsWith("ad_table_")) {
            return bh.VI(str.substring(9));
        }
        return bh.VI(str.substring(10));
    }

    public static boolean LH(String str) {
        if (str.startsWith("ad_table_")) {
            if (bh.VJ(str.substring(9)) != 0) {
                return true;
            }
            return false;
        } else if (bh.VJ(str.substring(10)) == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean LI(String str) {
        return !LH(str);
    }

    public static int en(String str, String str2) {
        g.Dh();
        return Y(str, str2, a.Ch());
    }

    public static int Y(String str, String str2, String str3) {
        String Z = Z(str, str2, str3);
        if (bh.ov(Z)) {
            return 0;
        }
        String[] split = Z.split("&");
        int i = 0;
        while (i < split.length) {
            if (split[i] != null && split[i].contains("voteResultIndex=")) {
                return Integer.valueOf(split[i].substring(16)).intValue();
            }
            i++;
        }
        return 0;
    }

    public static String Z(String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        if (str == null) {
            str = "";
        }
        stringBuilder.append(str);
        if (str2 == null) {
            str2 = "";
        }
        stringBuilder.append(str2);
        if (str3 == null) {
            str3 = "";
        }
        stringBuilder.append(str3);
        if (stringBuilder.length() > 0) {
            return ac.getContext().getSharedPreferences("SnsAdVote", 0).getString(stringBuilder.toString(), "");
        }
        return "";
    }

    public static void f(String str, String str2, String str3, int i, int i2) {
        if (!TextUtils.isEmpty(str)) {
            StringBuilder stringBuilder = new StringBuilder();
            if (str == null) {
                str = "";
            }
            stringBuilder.append(str);
            if (str2 == null) {
                str2 = "";
            }
            stringBuilder.append(str2);
            if (str3 == null) {
                str3 = "";
            }
            stringBuilder.append(str3);
            if (stringBuilder.length() > 0) {
                Editor edit = ac.getContext().getSharedPreferences("SnsAdVote", 0).edit();
                edit.putString(stringBuilder.toString(), "voteResultIndex=" + i + "&isUpdate=" + i2);
                edit.commit();
            }
        }
    }
}
