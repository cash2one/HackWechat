package com.tencent.mm.plugin.appbrand.config;

import android.os.HandlerThread;
import android.os.Looper;
import android.util.Pair;
import com.tencent.mm.ae.a.a;

class r$5 implements Runnable {
    final /* synthetic */ String gIT;
    final /* synthetic */ r$b iPd;
    final /* synthetic */ boolean iPe;

    r$5(String str, r$b com_tencent_mm_plugin_appbrand_config_r_b, boolean z) {
        this.gIT = str;
        this.iPd = com_tencent_mm_plugin_appbrand_config_r_b;
        this.iPe = z;
    }

    public final void run() {
        Pair a = r.a(this.gIT, false, new 1(this));
        if (this.iPd != null) {
            int i;
            if (a.second == null) {
                i = 1;
            } else if (((a) a.second).errType == 0 && ((a) a.second).errCode == 0) {
                i = 2;
            } else {
                i = 3;
            }
            this.iPd.d(i, a.first);
        }
        if (this.iPe) {
            try {
                ((HandlerThread) Looper.myLooper().getThread()).quit();
            } catch (Exception e) {
            }
        }
    }
}
