package com.tencent.mm.modelcdntran;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;

public final class d {
    public static int hsE = 1;
    public static int hsF = 2;
    public static int hsG = 3;
    public static int hsH = -1;
    public static int hsI = 3;
    public static int hsJ = 4;
    public static int hsK = 5;
    public static int hsL = 1;
    public static int hsM = 2;
    public static int hsN = -10001;
    public static int hsO = -10002;
    public static int hsP = -10003;
    public static int hsQ = -10004;

    public static void b(byte[] bArr, String str, int i) {
        if (bh.bw(bArr)) {
            bArr = new byte[0];
        }
        String str2 = new String(bArr);
        if (i == 4) {
            x.e(str, str2);
        } else if (i == 3) {
            x.w(str, str2);
        } else if (i == 2) {
            x.i(str, str2);
        } else if (i == 1) {
            x.d(str, str2);
        } else if (i == 0) {
            x.v(str, str2);
        }
    }

    private static String kJ(String str) {
        if (bh.ov(str)) {
            return str;
        }
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (!bh.o(charAt) && !bh.p(charAt)) {
                return null;
            }
        }
        return str;
    }

    public static String a(String str, long j, String str2, String str3) {
        x.d("MicroMsg.CdnUtil", "cdntra genClientId prefix[%s] createtime:%d talker[%s] suffix:[%s] stack[%s]", new Object[]{str, Long.valueOf(j), str2, str3, bh.cgy()});
        if (bh.ov(kJ(str)) || bh.ov(str2) || j <= 0) {
            return null;
        }
        String ou = bh.ou(kJ(str3));
        String str4 = "a" + str + "_" + g.s((q.FS() + "-" + str2).getBytes()).substring(0, 16) + "_" + j;
        if (bh.ov(ou)) {
            return str4;
        }
        return str4 + "_" + ou;
    }

    public static int bh(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return hsE;
            }
            if (activeNetworkInfo.getType() == 1) {
                return hsG;
            }
            if (activeNetworkInfo.getSubtype() == 1) {
                return hsE;
            }
            if (activeNetworkInfo.getSubtype() == 2) {
                return hsE;
            }
            if (activeNetworkInfo.getSubtype() >= 3) {
                return hsF;
            }
            return hsE;
        } catch (Throwable e) {
            x.e("MicroMsg.CdnUtil", "exception:%s", new Object[]{bh.i(e)});
            return hsE;
        }
    }

    public static int bi(Context context) {
        int netType = an.getNetType(context);
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return hsH;
        }
        if (activeNetworkInfo.getType() == 1) {
            return hsL;
        }
        if (activeNetworkInfo.getSubtype() == 1 || activeNetworkInfo.getSubtype() == 2) {
            return hsI;
        }
        if (activeNetworkInfo.getSubtype() >= 13) {
            return hsK;
        }
        if (activeNetworkInfo.getSubtype() >= 3) {
            return hsJ;
        }
        if (an.isWap(netType)) {
            return hsM;
        }
        return hsI;
    }
}
