package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.g.a.pf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.t;

public enum a {
    ;
    
    public static final c<pf> iIJ = null;

    static {
        iIJ = new 1();
    }

    public static boolean aaB() {
        if (!g.Dh().Cy()) {
            return false;
        }
        if (com.tencent.mm.k.g.zY().getInt("WeAppForbiddenSwitch", 0) == 1) {
            x.i("MicroMsg.AppBrandEntranceLogic", "showInFindMore, WeAppForbiddenSwitch == 1, not show");
            return false;
        } else if (aaG() || h.aaU()) {
            return true;
        } else {
            return false;
        }
    }

    public static void aaC() {
        if (g.Dh().Cy()) {
            if (aaD()) {
                h$e com_tencent_mm_plugin_appbrand_appusage_h_e = h$e.iJI;
                h$e.a("", 0, 2, 1);
            }
            g.Dj().CU().a(com.tencent.mm.storage.w.a.xrW, Boolean.valueOf(false));
        }
    }

    static boolean aaD() {
        if (g.Dh().Cy()) {
            return ((Boolean) g.Dj().CU().get(com.tencent.mm.storage.w.a.xrW, Boolean.valueOf(false))).booleanValue();
        }
        return false;
    }

    static void jB(int i) {
        boolean z = true;
        if (g.Dh().Cy()) {
            boolean z2;
            t CU = g.Dj().CU();
            if ((i & 2) > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            c(z2, "");
            com.tencent.mm.storage.w.a aVar = com.tencent.mm.storage.w.a.xrK;
            if ((i & 1) <= 0) {
                z = false;
            }
            CU.a(aVar, Boolean.valueOf(z));
        }
    }

    private static void c(boolean z, String str) {
        if (g.Dh().Cy()) {
            boolean z2;
            Boolean bool = (Boolean) g.Dj().CU().get(com.tencent.mm.storage.w.a.xrL, null);
            if (bool == null || bool.booleanValue() || !z) {
                z2 = false;
            } else {
                g.Dj().CU().a(com.tencent.mm.storage.w.a.xrW, Boolean.valueOf(true));
                h$e com_tencent_mm_plugin_appbrand_appusage_h_e = h$e.iJI;
                h$e.a("", 0, 1, 1);
                z2 = true;
            }
            g.Dj().CU().a(com.tencent.mm.storage.w.a.xrL, Boolean.valueOf(z));
            if (z2) {
                com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI.a Zf = f.Zf();
                if (Zf != null) {
                    Zf.jKH = true;
                    Zf.jKI = str;
                }
            }
        }
    }

    static void pZ(String str) {
        c(true, str);
    }

    public static boolean aaE() {
        if (g.Dh().Cy()) {
            return ((Boolean) g.Dj().CU().get(com.tencent.mm.storage.w.a.xrL, Boolean.valueOf(false))).booleanValue();
        }
        return false;
    }

    public static boolean aaF() {
        if (g.Dh().Cy()) {
            return ((Boolean) g.Dj().CU().get(com.tencent.mm.storage.w.a.xrK, Boolean.valueOf(false))).booleanValue();
        }
        return false;
    }

    public static boolean aaG() {
        return aaF() || aaE();
    }
}
