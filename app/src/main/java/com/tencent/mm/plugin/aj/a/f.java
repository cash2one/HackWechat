package com.tencent.mm.plugin.aj.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class f {
    public static void a(int i, String str, String str2, String str3, int i2, boolean z, String str4, String str5, int i3, String str6) {
        a(4, i, str, str2, str3, i2, z, str4, true, str5, str6, i3);
    }

    public static void a(int i, String str, String str2, String str3, int i2, boolean z, String str4, boolean z2, String str5, int i3) {
        a(i, str, str2, str3, i2, z, str4, z2, str5, i3, "");
    }

    public static void a(int i, String str, String str2, String str3, int i2, boolean z, String str4, boolean z2, String str5, int i3, String str6) {
        a(7, i, str, str2, str3, i2, z, str4, z2, str5, str6, i3);
    }

    public static void a(int i, String str, String str2, String str3, int i2) {
        a(10, i, str, str2, "", 0, true, "", true, str3, "", i2);
    }

    private static void a(int i, int i2, String str, String str2, String str3, int i3, boolean z, String str4, boolean z2, String str5, String str6, int i4) {
        a(i, i2, str, str2, str3, i3, z, str4, z2, str5, str6, i4, false);
    }

    public static void a(int i, int i2, String str, String str2, String str3, int i3, boolean z, String str4, boolean z2, String str5, String str6, int i4, boolean z3) {
        String str7;
        int i5 = z2 ? 1 : 2;
        if (i == 1 || i == 10 || i == 12) {
            i5 = 0;
        }
        String str8 = "MicroMsg.WebSearch.WebSearchActionTracer";
        String str9 = "reporting 14904 %s ";
        Object[] objArr = new Object[1];
        Object[] objArr2 = new Object[16];
        objArr2[0] = Integer.valueOf(i);
        objArr2[1] = Integer.valueOf(i2);
        objArr2[2] = bh.az(str, "");
        objArr2[3] = bh.az(str2, "");
        if (TextUtils.isEmpty(str3)) {
            str7 = "";
        } else {
            str7 = str3;
        }
        objArr2[4] = str7;
        objArr2[5] = Integer.valueOf(i3);
        objArr2[6] = Integer.valueOf(z ? 1 : 0);
        objArr2[7] = bh.az(str4, "");
        objArr2[8] = Long.valueOf(System.currentTimeMillis());
        objArr2[9] = bOQ();
        objArr2[10] = Integer.valueOf(i5);
        objArr2[11] = bh.az(str5, "");
        objArr2[12] = TextUtils.isEmpty(str6) ? "" : str6;
        objArr2[13] = Integer.valueOf(i4);
        objArr2[14] = Integer.valueOf(zG(i2) ? g.zN(0) : g.zN(1));
        objArr2[15] = Integer.valueOf(z3 ? 1 : 0);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i6 = 0; i6 < 15; i6++) {
            stringBuilder.append(String.valueOf(objArr2[i6]).replace(',', ' ')).append(',');
        }
        stringBuilder.append(String.valueOf(objArr2[15]));
        objArr[0] = stringBuilder.toString();
        x.v(str8, str9, objArr);
        d dVar = d.pPH;
        objArr = new Object[16];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = bh.az(str, "");
        objArr[3] = bh.az(str2, "");
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        objArr[4] = str3;
        objArr[5] = Integer.valueOf(i3);
        objArr[6] = Integer.valueOf(z ? 1 : 0);
        objArr[7] = bh.az(str4, "");
        objArr[8] = Long.valueOf(System.currentTimeMillis());
        objArr[9] = bOQ();
        objArr[10] = Integer.valueOf(i5);
        objArr[11] = bh.az(str5, "");
        if (TextUtils.isEmpty(str6)) {
            str6 = "";
        }
        objArr[12] = str6;
        objArr[13] = Integer.valueOf(i4);
        objArr[14] = Integer.valueOf(zG(i2) ? g.zN(0) : g.zN(1));
        objArr[15] = Integer.valueOf(z3 ? 1 : 0);
        dVar.h(14904, objArr);
    }

    private static boolean zG(int i) {
        return i != 21;
    }

    private static String bOQ() {
        Context context = ac.getContext();
        if (an.isConnected(context)) {
            x.v("MicroMsg.WebSearch.WebSearchActionTracer", "getNetworkType, type = " + an.getNetType(context));
            if (an.is2G(context)) {
                x.v("MicroMsg.WebSearch.WebSearchActionTracer", "getNetworkType, 2g");
                return "2g";
            } else if (an.is3G(context)) {
                x.v("MicroMsg.WebSearch.WebSearchActionTracer", "getNetworkType, 3g");
                return "3g";
            } else if (an.is4G(context)) {
                x.v("MicroMsg.WebSearch.WebSearchActionTracer", "getNetworkType, 4g");
                return "4g";
            } else if (!an.isWifi(context)) {
                return "fail";
            } else {
                x.v("MicroMsg.WebSearch.WebSearchActionTracer", "getNetworkType, wifi");
                return "wifi";
            }
        }
        x.v("MicroMsg.WebSearch.WebSearchActionTracer", "getNetworkType, not connected");
        return "fail";
    }
}
