package com.tencent.mm.plugin.appbrand.jsapi.b;

import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.c$c;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.x;

class l$2 extends b {
    final /* synthetic */ j iZy;
    final /* synthetic */ l jhO;

    l$2(l lVar, j jVar) {
        this.jhO = lVar;
        this.iZy = jVar;
    }

    public final void onResume() {
    }

    public final void a(c$c com_tencent_mm_plugin_appbrand_c_c) {
    }

    public final void onDestroy() {
        x.i("MicroMsg.JsApiOpenBluetoothAdapter", "lifecycle destroy...");
        if (this.iZy != null) {
            if (l.jhN != null) {
                x.i("MicroMsg.JsApiOpenBluetoothAdapter", "unregisterReceiver");
                this.iZy.getContext().unregisterReceiver(l.jhN);
                l.jhN = null;
            }
            c.b(this.iZy.mAppId, this);
        }
    }
}
