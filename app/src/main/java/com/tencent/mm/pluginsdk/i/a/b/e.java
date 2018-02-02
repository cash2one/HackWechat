package com.tencent.mm.pluginsdk.i.a.b;

import com.tencent.mm.pluginsdk.i.a.b.b.c;
import com.tencent.mm.pluginsdk.i.a.b.i.a;
import com.tencent.mm.pluginsdk.i.a.b.i.b;
import com.tencent.mm.protocal.c.bcy;
import com.tencent.mm.protocal.c.bda;
import com.tencent.mm.protocal.c.bdb;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

final class e {
    private static boolean r(String str, Map<String, String> map) {
        if (map.get(str) == null && map.get(str + ".resType") == null && map.get(str + ".subType") == null) {
            return true;
        }
        return false;
    }

    static void f(String str, String str2, Map<String, String> map) {
        if (!r(String.format("%s.%s", new Object[]{str, str2}), map)) {
            int g = g(str, str2, map) | 0;
            int i = 0;
            while (true) {
                i++;
                if (r(String.format("%s.%s%d", new Object[]{str, str2, Integer.valueOf(i)}), map)) {
                    break;
                }
                g |= g(str, str2, map);
            }
            i = b.RT(str2);
            if (b.BM(i)) {
                j.I(0, 32);
                if (g == 0) {
                    j.I(0, 33);
                }
            } else if (b.BN(i)) {
                j.I(0, 35);
                if (g == 0) {
                    j.I(0, 36);
                }
            } else if (b.BO(i)) {
                j.I(0, 38);
                if (g == 0) {
                    j.I(0, 39);
                }
            }
        }
    }

    private static boolean g(String str, String str2, Map<String, String> map) {
        String format = String.format("%s.%s.%s", new Object[]{str, str2, "Resource"});
        int RT = b.RT(str2);
        if (r(format, map)) {
            return true;
        }
        boolean d = d(RT, format, map) | 0;
        int i = 0;
        while (true) {
            i++;
            String format2 = String.format("%s.%s.%s%d", new Object[]{str, str2, "Resource", Integer.valueOf(i)});
            if (r(format2, map)) {
                return d;
            }
            d |= d(RT, format2, map);
        }
    }

    private static boolean d(int i, String str, Map<String, String> map) {
        if (map.get(str + ".resType") == null && map.get(str + ".subType") == null) {
            return true;
        }
        int i2;
        int i3;
        bcy com_tencent_mm_protocal_c_bcy;
        if (b.BO(i)) {
            x.d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceDelete()");
            i2 = bh.getInt((String) map.get(str + ".resType"), -1);
            i3 = bh.getInt((String) map.get(str + ".subType"), -1);
            if (-1 == i2 || -1 == i3) {
                return false;
            }
            com_tencent_mm_protocal_c_bcy = new bcy();
            com_tencent_mm_protocal_c_bcy.wFj = i3;
            com_tencent_mm_protocal_c_bcy.wJb = new bdb();
            com_tencent_mm_protocal_c_bcy.wJb.wJl = bh.getInt((String) map.get(str + ".resVer"), 0);
            com_tencent_mm_protocal_c_bcy.wJe = (String) map.get(str + ".sampleID");
            com_tencent_mm_protocal_c_bcy.wJd = bh.getInt((String) map.get(str + ".reportID"), 0);
            com_tencent_mm_protocal_c_bcy.wlp = b.vgZ.fDt;
            c.bZm().a(i2, com_tencent_mm_protocal_c_bcy, true);
            j.I((long) com_tencent_mm_protocal_c_bcy.wJd, 40);
            return true;
        } else if (b.BM(i)) {
            x.d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceCache()");
            String str2 = (String) map.get(str + ".CDNUrl");
            int i4 = bh.getInt((String) map.get(str + ".subType"), -1);
            int i5 = bh.getInt((String) map.get(str + ".resType"), -1);
            String str3 = (String) map.get(str + ".md5");
            int i6 = bh.getInt((String) map.get(str + ".priority"), 0);
            if (bh.ov(str2) || bh.ov(str3) || -1 == i4 || -1 == i5 || i6 < 0) {
                return false;
            }
            int bZp;
            bcy com_tencent_mm_protocal_c_bcy2 = new bcy();
            com_tencent_mm_protocal_c_bcy2.wJb = new bdb();
            if (bh.getInt((String) map.get(str + ".fileEncrypt"), 0) > 0) {
                bZp = a.bZp();
            } else {
                bZp = 0;
            }
            if (bh.getInt((String) map.get(str + ".fileCompress"), 0) > 0) {
                bZp = a.BK(bZp);
            }
            com_tencent_mm_protocal_c_bcy2.wFj = i4;
            com_tencent_mm_protocal_c_bcy2.wJg = bh.getInt((String) map.get(str + ".networkType"), 2);
            com_tencent_mm_protocal_c_bcy2.vQa = bh.getInt((String) map.get(str + ".expireTime"), 1);
            com_tencent_mm_protocal_c_bcy2.wJb.nfX = str2;
            com_tencent_mm_protocal_c_bcy2.wJb.wJl = bh.getInt((String) map.get(str + ".resVer"), 0);
            com_tencent_mm_protocal_c_bcy2.wJb.vZU = str3;
            com_tencent_mm_protocal_c_bcy2.wJb.wJo = (String) map.get(str + ".originalmd5");
            com_tencent_mm_protocal_c_bcy2.wJb.wJm = bZp;
            com_tencent_mm_protocal_c_bcy2.wJb.wJn = null;
            com_tencent_mm_protocal_c_bcy2.wJb.vZC = null;
            com_tencent_mm_protocal_c_bcy2.wrD = i6;
            com_tencent_mm_protocal_c_bcy2.wlp = b.vgX.fDt;
            com_tencent_mm_protocal_c_bcy2.wJd = bh.getInt((String) map.get(str + ".reportID"), 0);
            com_tencent_mm_protocal_c_bcy2.wJe = (String) map.get(str + ".sampleID");
            com_tencent_mm_protocal_c_bcy2.wJf = bh.getInt((String) map.get(str + ".retryTime"), 3);
            com_tencent_mm_protocal_c_bcy2.wJh = bh.getInt((String) map.get(str + ".retryInterval"), 0);
            com_tencent_mm_protocal_c_bcy2.vgO = 0;
            c.bZm().b(i5, com_tencent_mm_protocal_c_bcy2, true);
            j.I((long) com_tencent_mm_protocal_c_bcy2.wJd, 34);
            return true;
        } else if (!b.BN(i)) {
            return false;
        } else {
            x.d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceDecrypt()");
            i2 = bh.getInt((String) map.get(str + ".resType"), -1);
            i3 = bh.getInt((String) map.get(str + ".subType"), -1);
            if (-1 == i2 || -1 == i3) {
                return false;
            }
            com_tencent_mm_protocal_c_bcy = new bcy();
            com_tencent_mm_protocal_c_bcy.wJc = new bda();
            com_tencent_mm_protocal_c_bcy.wFj = i3;
            com_tencent_mm_protocal_c_bcy.wJc.wJk = (String) map.get(str + ".resKey");
            com_tencent_mm_protocal_c_bcy.wJc.wJj = bh.getInt((String) map.get(str + ".resKeyVersion"), 0);
            com_tencent_mm_protocal_c_bcy.wJe = (String) map.get(str + ".sampleID");
            com_tencent_mm_protocal_c_bcy.wJd = bh.getInt((String) map.get(str + ".reportID"), 0);
            com_tencent_mm_protocal_c_bcy.wlp = b.vgY.fDt;
            com_tencent_mm_protocal_c_bcy.wJb = new bdb();
            com_tencent_mm_protocal_c_bcy.wJb.wJo = (String) map.get(str + ".originalmd5");
            c.bZm().c(i2, com_tencent_mm_protocal_c_bcy, true);
            j.I((long) com_tencent_mm_protocal_c_bcy.wJd, 37);
            return true;
        }
    }
}
