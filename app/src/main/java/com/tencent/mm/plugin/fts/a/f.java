package com.tencent.mm.plugin.fts.a;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.HashMap;

public final class f {
    public static HashMap<String, String> icD = new HashMap();
    public static final a mKP = new a(19968, 40869);
    public static final a mKQ = new a(40870, 40907);
    public static final a mKR = new a(13312, 19893);
    public static final a mKS = new a(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 173782);
    public static final a mKT = new a(173824, 177972);
    public static final a mKU = new a(177984, 178205);
    public static final a mKV = new a(12032, 12245);
    public static final a mKW = new a(63744, 64217);
    public static final a mKX = new a(194560, 195101);
    public static final a mKY = new a(59413, 59503);
    public static final a mKZ = new a(58368, 58856);
    public static final a mLa = new a(58880, 59087);
    public static final a mLb = new a(12736, 12771);
    public static final a mLc = new a(12272, 12283);
    public static final a mLd = new a(12549, 12576);
    public static final a mLe = new a(12704, 12730);
    public static final a mLf = new a(65, 90);
    public static final a mLg = new a(97, 122);
    public static final a mLh = new a(48, 57);
    public static b mLi = new b();
    public static HashMap<String, String[]> mLj = new HashMap();

    public static boolean i(char c) {
        return mKP.l(c) || mKQ.l(c) || mKR.l(c) || mKS.l(c) || mKT.l(c) || mKU.l(c);
    }

    public static boolean j(char c) {
        return mLf.l(c) || mLg.l(c);
    }

    public static boolean k(char c) {
        return mLh.l(c);
    }

    public static final String Bf(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (char c : str.toCharArray()) {
            if (i(c)) {
                String str2 = (String) icD.get(String.valueOf(c));
                if (!bh.ov(str2)) {
                    stringBuffer.append(str2);
                }
            }
            stringBuffer.append(c);
        }
        return stringBuffer.toString();
    }
}
