package com.tencent.mm.plugin.appbrand.jsapi.lbs;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;

class c$1 implements a {
    final /* synthetic */ j iZy;
    final /* synthetic */ c jkk;

    c$1(c cVar, j jVar) {
        this.jkk = cVar;
        this.iZy = jVar;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i != 1) {
            return;
        }
        if (i2 == -1) {
            if (intent == null) {
                this.iZy.E(this.jkk.jcs, this.jkk.e("fail", null));
                x.e("MicroMsg.JsApiChooseLocation", "location result is empty!");
                return;
            }
            Addr addr = (Addr) intent.getParcelableExtra("key_pick_addr");
            Map hashMap = new HashMap();
            if (addr != null) {
                x.i("MicroMsg.JsApiChooseLocation", "addr: " + addr.toString());
                StringBuilder stringBuilder = new StringBuilder();
                if (TextUtils.isEmpty(addr.hxu)) {
                    stringBuilder.append(addr.OM());
                } else {
                    stringBuilder.append(addr.hxu);
                }
                hashMap.put("address", stringBuilder.toString());
                if (TextUtils.isEmpty(addr.hxD)) {
                    hashMap.put("name", stringBuilder.toString());
                } else {
                    hashMap.put("name", addr.hxD);
                }
                hashMap.put("latitude", Float.valueOf(addr.hxF));
                hashMap.put("longitude", Float.valueOf(addr.hxG));
                this.iZy.E(this.jkk.jcs, this.jkk.e("ok", hashMap));
                return;
            }
            this.iZy.E(this.jkk.jcs, this.jkk.e("fail", null));
            x.e("MicroMsg.JsApiChooseLocation", "location result is empty!");
        } else if (i2 == 0) {
            this.iZy.E(this.jkk.jcs, this.jkk.e("cancel", null));
            x.e("MicroMsg.JsApiChooseLocation", "location result is cancel!");
        } else {
            this.iZy.E(this.jkk.jcs, this.jkk.e("fail", null));
            x.e("MicroMsg.JsApiChooseLocation", "location result is fail!");
        }
    }
}
