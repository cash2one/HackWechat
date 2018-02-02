package com.tencent.mm.booter;

import com.tencent.mm.a.h;
import com.tencent.mm.k.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class j {
    public static void run() {
        int i = g.zY().getInt("EnableForgroundService", 0);
        ar.Hg();
        int aJ = h.aJ(c.Cg(), 101);
        boolean z = b.ceK() || (i > 0 && aJ >= 0 && aJ <= i);
        if (!z) {
            z = d.vAC;
        }
        if (!z) {
            z = b.ceK();
        }
        if (f.fdS == 1) {
            z = false;
        }
        ac.getContext().getSharedPreferences("system_config_prefs", 0).edit().putBoolean("set_service", z).commit();
        x.i("MicroMsg.PostTaskSetPushForegroundService", "Set service, userHash:%d, prob:%d, enabled: %b  isalpha:%b channel:%d", new Object[]{Integer.valueOf(aJ), Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(d.vAC), Integer.valueOf(f.fdS)});
    }
}
