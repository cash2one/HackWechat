package com.tencent.mm.plugin.soter.c;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.d.a.a;
import com.tencent.d.a.c.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    public static c bCP() {
        SharedPreferences cft = ac.cft();
        if (cft == null) {
            return new c();
        }
        String string = cft.getString("cpu_id", "");
        String string2 = cft.getString("uid", "");
        if (bh.ov(string) || bh.ov(string2)) {
            x.w("MicroMsg.SoterDeviceInfoManager", "hy: no cpu id and uid retrieved. load again");
            h cFN = a.cFN();
            if (cFN != null) {
                string = cFN.rSm;
                string2 = String.valueOf(cFN.uid);
                if (!(bh.ov(string) || bh.ov(string2))) {
                    eq(string, string2);
                    return new c(string, string2);
                }
            }
            return new c();
        }
        x.i("MicroMsg.SoterDeviceInfoManager", "hy:device info exists in preference. directly return");
        return new c(string, string2);
    }

    public static void eq(String str, String str2) {
        SharedPreferences cft = ac.cft();
        if (cft != null) {
            x.i("MicroMsg.SoterDeviceInfoManager", "hy: save device info");
            Editor edit = cft.edit();
            edit.putString("cpu_id", str);
            edit.putString("uid", str2);
            edit.apply();
        }
    }
}
