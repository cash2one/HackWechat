package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;

class ap$1 implements a {
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ ap jdx;

    ap$1(ap apVar, j jVar, int i) {
        this.jdx = apVar;
        this.iZy = jVar;
        this.gOK = i;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i == (this.jdx.hashCode() & 65535)) {
            if (intent != null) {
                x.i("MicroMsg.JsApiOpenOfflinePayView", "callback: %s", intent.getStringExtra("key_callback"));
                this.iZy.E(this.gOK, this.jdx.e(r0, null));
                g.pQN.h(14954, f.ccU(), "openOfflinePayView:ok");
            } else {
                this.iZy.E(this.gOK, this.jdx.e("fail", null));
                if (!f.ccT()) {
                    g.pQN.h(14954, f.ccU(), "openOfflinePayView:fail");
                }
            }
            if (!f.ccT()) {
                f.ccV();
            }
        }
    }
}
