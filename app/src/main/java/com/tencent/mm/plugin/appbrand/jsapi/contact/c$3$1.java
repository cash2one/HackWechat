package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c.3;
import com.tencent.mm.plugin.appbrand.p.l;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;

class c$3$1 implements a {
    final /* synthetic */ 3 jiW;

    c$3$1(3 3) {
        this.jiW = 3;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i == 1) {
            if (c.jfv > 0) {
                c.jfv--;
                c.f(this.jiW.jiR).irP.YE();
            }
            x.i("MicroMsg.JsApiEnterContact", "mmOnActivityResult lockCount:%d", new Object[]{Integer.valueOf(c.jfv)});
            this.jiW.jiU.afj();
            Map hashMap = new HashMap();
            Object obj = "";
            Object hashMap2 = new HashMap();
            if (i2 == -1 && intent != null) {
                String az = bh.az(intent.getStringExtra("keyOutPagePath"), "");
                obj = l.uB(az);
                hashMap2 = l.uC(az);
            }
            hashMap.put("path", obj);
            hashMap.put("query", hashMap2);
            x.i("MicroMsg.JsApiEnterContact", "onBackFromContact path:%s, query:%s", new Object[]{obj, hashMap2.toString()});
            c.f(this.jiW.jiR).E(this.jiW.gOK, this.jiW.jiR.e("ok", hashMap));
        }
    }
}
