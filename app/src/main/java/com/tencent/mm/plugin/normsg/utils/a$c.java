package com.tencent.mm.plugin.normsg.utils;

import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;
import java.util.Map;

final class a$c {
    private a$c() {
    }

    public static boolean isEnabled() {
        StringBuilder stringBuilder = new StringBuilder();
        String stringBuilder2;
        try {
            stringBuilder.append(c.GG("Úà¯ßºÔ"));
            stringBuilder2 = stringBuilder.toString();
            stringBuilder.delete(0, stringBuilder.length());
            stringBuilder.append(((a$c.class.hashCode() >>> 31) | 1) ^ 1);
            if (stringBuilder.toString().equals(dD(stringBuilder2, stringBuilder.toString()))) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            stringBuilder2 = stringBuilder.toString();
            stringBuilder.delete(0, stringBuilder.length());
            stringBuilder.append(((a$c.class.hashCode() >>> 31) | 1) ^ 1);
            if (stringBuilder.toString().equals(dD(stringBuilder2, stringBuilder.toString()))) {
                return false;
            }
            return true;
        }
    }

    static boolean bfP() {
        StringBuilder stringBuilder = new StringBuilder();
        String stringBuilder2;
        try {
            stringBuilder.append(c.GG("Þä¦Ê¡ã¡"));
            stringBuilder2 = stringBuilder.toString();
            stringBuilder.delete(0, stringBuilder.length());
            stringBuilder.append(((a$c.class.hashCode() >>> 31) | 1) ^ 1);
            if (stringBuilder.toString().equals(dD(stringBuilder2, stringBuilder.toString()))) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            stringBuilder2 = stringBuilder.toString();
            stringBuilder.delete(0, stringBuilder.length());
            stringBuilder.append(((a$c.class.hashCode() >>> 31) | 1) ^ 1);
            if (stringBuilder.toString().equals(dD(stringBuilder2, stringBuilder.toString()))) {
                return false;
            }
            return true;
        }
    }

    public static int bfQ() {
        int hashCode;
        int hashCode2;
        Throwable th;
        Throwable th2;
        StringBuilder stringBuilder = new StringBuilder();
        String stringBuilder2;
        try {
            stringBuilder.append(c.GG("S\u0000D\u000fF(\\\tK"));
            hashCode = (a$c.class.hashCode() >>> 31) | 1;
            stringBuilder2 = stringBuilder.toString();
            if (hashCode == 0) {
                return hashCode;
            }
            try {
                hashCode2 = ((a$c.class.hashCode() >>> 31) | 1) ^ 1;
                try {
                    stringBuilder.delete(0, stringBuilder.length());
                    stringBuilder.append(hashCode2);
                    return bh.getInt(dD(stringBuilder2, stringBuilder.toString()), hashCode2);
                } catch (Throwable th3) {
                    th = th3;
                    stringBuilder.append(hashCode2);
                    throw th;
                }
            } catch (Throwable th4) {
                th2 = th4;
                hashCode2 = hashCode;
                th = th2;
                stringBuilder.append(hashCode2);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            stringBuilder.append(hashCode2);
            throw th;
        }
    }

    private static String dD(String str, String str2) {
        try {
            g.Dh().Ct();
            try {
                a aVar = b.gNk;
                c fn = a.fn("100373");
                if (fn == null || !fn.isValid()) {
                    x.w("MircoMsg.AEDHLP", "check point 1, explained by src code.");
                    return str2;
                }
                Map chI = fn.chI();
                if (chI == null) {
                    x.w("MircoMsg.AEDHLP", "check point 2, explained by src code.");
                    return str2;
                }
                String str3 = (String) chI.get(str);
                if (str3 == null || str3.length() <= 0) {
                    return str2;
                }
                return str3;
            } catch (Throwable e) {
                x.printErrStackTrace("MircoMsg.AEDHLP", e, "check point 1-1, explained by src code.", new Object[0]);
                return str2;
            }
        } catch (com.tencent.mm.z.b e2) {
            x.w("MircoMsg.AEDHLP", "check point 0, explained by src code.");
            return str2;
        }
    }
}
