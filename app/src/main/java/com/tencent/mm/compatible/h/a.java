package com.tencent.mm.compatible.h;

import android.content.SharedPreferences;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.compatible.d.u;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    private static int gHj = 0;

    public static boolean zc() {
        if (b.yZ()) {
            boolean z;
            u uVar = q.gFZ;
            if (!ac.cfw()) {
                uVar.gGx = MultiProcessSharedPreferences.getSharedPreferences(ac.getContext(), "system_config_prefs", 4).getInt("update_swip_back_status", 0);
            }
            if (uVar.gGx == 1) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return false;
            }
        }
        if (gHj == 0) {
            SharedPreferences cft = ac.cft();
            if (cft == null || !cft.getBoolean("settings_support_swipe", true)) {
                gHj = 2;
            } else {
                gHj = 1;
            }
        }
        if (gHj == 1) {
            return true;
        }
        return false;
    }

    public static void bi(boolean z) {
        SharedPreferences cft = ac.cft();
        if (cft.getBoolean("settings_support_swipe", true) != z) {
            cft.edit().putBoolean("settings_support_swipe", z).commit();
        }
        x.i("MicroMsg.StyleUtil", "switchSwipebackMode, from %B to %B", Boolean.valueOf(r1), Boolean.valueOf(z));
    }
}
