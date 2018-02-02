package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;

class g$1 implements a {
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ g jpg;

    g$1(g gVar, j jVar, int i) {
        this.jpg = gVar;
        this.iZy = jVar;
        this.gOK = i;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i == (this.jpg.hashCode() & 65535)) {
            this.jpg.jpf = false;
            if (i2 == -1) {
                int intExtra = intent.getIntExtra("key_err_code", 1);
                if (intExtra == 0) {
                    x.e("MicroMsg.JsApiRequestVirtualPayment", "requestIAP ok");
                    this.iZy.E(this.gOK, this.jpg.e("ok", null));
                    return;
                }
                Map hashMap = new HashMap();
                String ou = bh.ou(intent.getStringExtra("key_err_msg"));
                hashMap.put("errCode", Integer.valueOf(intExtra));
                x.e("MicroMsg.JsApiRequestVirtualPayment", "requestVirtualPayment errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(intExtra), ou});
                this.iZy.E(this.gOK, this.jpg.e("fail " + ou, hashMap));
                return;
            }
            this.iZy.E(this.gOK, this.jpg.e("cancel", null));
        }
    }
}
