package com.tencent.mm.plugin.freewifi.model;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class g$2 implements Runnable {
    final /* synthetic */ String mDz;
    final /* synthetic */ g mEo;
    final /* synthetic */ String mEp;
    final /* synthetic */ g$a mEq = null;
    final /* synthetic */ Intent val$intent;

    g$2(g gVar, String str, String str2, Intent intent, g$a com_tencent_mm_plugin_freewifi_model_g_a) {
        this.mEo = gVar;
        this.mEp = str;
        this.mDz = str2;
        this.val$intent = intent;
    }

    public final void run() {
        String AN = g.AN(this.mEp);
        x.i("MicroMsg.FreeWifi.FreeWifiNetwork", "get redirect location from loginurl : %s, %s", new Object[]{AN, this.mEp});
        if (!bh.ov(AN)) {
            String cB = g.cB(AN, "res=");
            x.i("MicroMsg.FreeWifi.FreeWifiNetwork", "get connect result from location : %s, %s", new Object[]{cB, AN});
            if (!bh.ov(cB) && (cB.startsWith("success") || cB.startsWith("already"))) {
                g.b(this.mDz, 2, this.val$intent);
                j.aLO().AS(this.mDz);
                return;
            }
        }
        g.b(this.mDz, 3, this.val$intent);
    }
}
