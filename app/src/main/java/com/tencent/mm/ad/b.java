package com.tencent.mm.ad;

import android.graphics.Bitmap;
import com.tencent.mm.a.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.arp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.x;
import com.tencent.mm.z.q;

public final class b {
    public static String ab(String str, String str2) {
        return str + "?access_token=" + str2;
    }

    public static Bitmap iO(String str) {
        return a(str + "@google", false, -1);
    }

    private static String iP(String str) {
        return "http://graph.facebook.com/" + str + "/picture";
    }

    public static void iQ(String str) {
        if (!bh.ov(str)) {
            String str2 = str + "@fb";
            h jm = n.JQ().jm(str2);
            if (jm == null || !str2.equals(jm.getUsername()) || 3 != jm.fWe) {
                if (jm == null) {
                    jm = new h();
                }
                jm.username = str2;
                jm.fWe = 3;
                jm.hly = iP(str);
                jm.hlx = iP(str);
                jm.bA(true);
                jm.fDt = 31;
                n.JQ().a(jm);
            }
        }
    }

    public static Bitmap iR(String str) {
        return a(str + "@fb", false, -1);
    }

    public static long iS(String str) {
        long j = -1;
        if (x.WA(str)) {
            try {
                j = bh.getLong(str.split("@")[0], -1);
            } catch (Exception e) {
            }
        }
        return j;
    }

    private static String aN(long j) {
        return new o(j) + "@qqim";
    }

    public static long iT(String str) {
        long j = -1;
        if (x.Wz(str)) {
            try {
                j = bh.getLong(str.split("@")[0], -1);
            } catch (Exception e) {
            }
        }
        return j;
    }

    public static boolean c(long j, int i) {
        if (i != 3) {
            return false;
        }
        return iU(aN(j));
    }

    public static boolean iU(String str) {
        if (str == null) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.AvatarLogic", "setQQAvatarImgFlag failed : invalid username");
            return false;
        } else if (str.endsWith("@qqim")) {
            h hVar = new h();
            hVar.username = str;
            hVar.fWe = 3;
            hVar.fDt = 3;
            return n.JQ().a(hVar);
        } else {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.AvatarLogic", "setQQAvatarImgFlag failed : invalid username");
            return false;
        }
    }

    public static Bitmap aO(long j) {
        return a(aN(j), false, -1);
    }

    public static boolean I(String str, int i) {
        if (bh.ov(str)) {
            return false;
        }
        h jm = n.JQ().jm(str);
        if (jm != null && str.equals(jm.getUsername()) && i == jm.fWe) {
            return true;
        }
        if (jm == null) {
            jm = new h();
        }
        jm.username = str;
        jm.fWe = i;
        jm.fDt = 3;
        return n.JQ().a(jm);
    }

    public static Bitmap iV(String str) {
        return a(str, false, -1);
    }

    public static Bitmap c(String str, int i, int i2, int i3) {
        if (bh.ov(str) || !g.Dh().Cy()) {
            return null;
        }
        Bitmap bitmap;
        n.Jz();
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.AvatarStorage", "getHDBitmap user:%s, width:%d, height:%d", str, Integer.valueOf(i), Integer.valueOf(i2));
        if (bh.ov(str)) {
            bitmap = null;
        } else {
            bitmap = d.a(d.x(str, true), i, i2, null, 0, 0, 1);
        }
        if (bitmap == null) {
            final e eVar = new e();
            eVar.a(str, new com.tencent.mm.ad.e.b() {
                public final int ba(int i, int i2) {
                    eVar.JD();
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.AvatarLogic", "getHDHeadImage onSceneEnd: errType=%d, errCode=%d", Integer.valueOf(i), Integer.valueOf(i2));
                    return 0;
                }
            });
            return a(str, false, i3);
        } else if (i3 > 5) {
            return d.a(bitmap, false, (float) i3);
        } else {
            return bitmap;
        }
    }

    public static Bitmap a(String str, boolean z, int i) {
        if (bh.ov(str) || !g.Dh().Cy()) {
            return null;
        }
        if (!g.Dj().CX()) {
            return n.Jz().bg(ac.getContext());
        }
        if (x.gy(str)) {
            str = x.WD(str);
        }
        return n.JS().b(str, z, i);
    }

    public static String iW(String str) {
        if (bh.ov(str) || !g.Dh().Cy() || !g.Dj().CX()) {
            return null;
        }
        if (x.gy(str)) {
            n.Jz();
            return d.x(x.WD(str), false);
        }
        n.Jz();
        return d.x(str, false);
    }

    public static void iX(String str) {
        h jm = n.JQ().jm(str);
        if (jm != null && str.equals(jm.getUsername())) {
            jm.hlA = 0;
            jm.fDt = 64;
            n.JQ().a(jm);
        }
    }

    public static h a(String str, arp com_tencent_mm_protocal_c_arp) {
        h hVar = new h();
        hVar.fDt = -1;
        hVar.username = str;
        hVar.hlx = com_tencent_mm_protocal_c_arp.vUV;
        hVar.hly = com_tencent_mm_protocal_c_arp.vUU;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.AvatarLogic", "dkhurl contact %s b[%s] s[%s]", hVar.getUsername(), hVar.JG(), hVar.JH());
        hVar.bA(com_tencent_mm_protocal_c_arp.wzd != 0);
        if (com_tencent_mm_protocal_c_arp.wyY == 3 || com_tencent_mm_protocal_c_arp.wyY == 4) {
            hVar.fWe = com_tencent_mm_protocal_c_arp.wyY;
        } else if (com_tencent_mm_protocal_c_arp.wyY == 2) {
            hVar.fWe = 3;
            if (!q.FS().equals(str)) {
                n.Jz();
                d.y(str, false);
                n.Jz();
                d.y(str, true);
                n.JS().iY(str);
            }
        }
        return hVar;
    }
}
