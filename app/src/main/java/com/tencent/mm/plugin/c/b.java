package com.tencent.mm.plugin.c;

import com.tencent.mm.plugin.report.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.z.bh;

public final class b {
    public static void jd(int i) {
        if (i > 0) {
            if (bh.HO().HP() > 0) {
                bh.HO();
                if (i != 20) {
                    return;
                }
            }
            ac.getContext().getSharedPreferences(ac.cfs(), 0).edit().putInt("reg_style_id", i).commit();
        }
    }

    private static int Og() {
        return ac.getContext().getSharedPreferences(ac.cfs(), 0).getInt("reg_style_id", 0);
    }

    public static void oG(String str) {
        ac.getContext().getSharedPreferences(ac.cfs(), 0).edit().putString("reg_last_exit_ui", str).commit();
    }

    public static String Xn() {
        return ac.getContext().getSharedPreferences(ac.cfs(), 0).getString("reg_last_exit_ui", "");
    }

    public static void oH(String str) {
        ac.getContext().getSharedPreferences(ac.cfs(), 0).edit().putString("reg_next_enter_ui", str).commit();
    }

    public static void oI(String str) {
        d.pPH.a(10645, str + "," + Og() + "," + com.tencent.mm.sdk.platformtools.bh.Wp() + "," + Xn(), true, true);
    }

    public static void b(boolean z, String str) {
        String str2;
        if (z) {
            str2 = str + "," + Og() + "," + com.tencent.mm.sdk.platformtools.bh.Wp() + "," + Xn();
        } else {
            str2 = str + "," + Og() + "," + com.tencent.mm.sdk.platformtools.bh.Wp() + "," + ac.getContext().getSharedPreferences(ac.cfs(), 0).getString("reg_next_enter_ui", "");
        }
        d.pPH.a(10645, str2, true, true);
    }
}
