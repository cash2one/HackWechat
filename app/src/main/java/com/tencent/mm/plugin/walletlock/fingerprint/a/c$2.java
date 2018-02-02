package com.tencent.mm.plugin.walletlock.fingerprint.a;

import android.content.SharedPreferences;
import com.tencent.mm.plugin.soter.c.e;

class c$2 implements e {
    final /* synthetic */ c tfy;
    final /* synthetic */ SharedPreferences tfz;

    c$2(c cVar, SharedPreferences sharedPreferences) {
        this.tfy = cVar;
        this.tfz = sharedPreferences;
    }

    public final void yc(int i) {
        if (!this.tfy.pou) {
            if (i == 0) {
                c.eD(this.tfz.getString("cpu_id", null), this.tfz.getString("uid", null));
            } else if (this.tfy.tfv != null) {
                this.tfy.tfv.ac(2, "init soter failed");
            }
        }
    }
}
