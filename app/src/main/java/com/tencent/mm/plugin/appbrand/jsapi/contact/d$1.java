package com.tencent.mm.plugin.appbrand.jsapi.contact;

import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class d$1 implements Runnable {
    final /* synthetic */ int gOK;
    final /* synthetic */ p jdJ;
    final /* synthetic */ JsApiGetContactMessageCountTask jiX;
    final /* synthetic */ d jiY;

    d$1(d dVar, JsApiGetContactMessageCountTask jsApiGetContactMessageCountTask, p pVar, int i) {
        this.jiY = dVar;
        this.jiX = jsApiGetContactMessageCountTask;
        this.jdJ = pVar;
        this.gOK = i;
    }

    public final void run() {
        Map hashMap = new HashMap();
        hashMap.put("count", this.jiX.fnm);
        x.i("MicroMsg.JsApiGetAppConfig", "JsApiGetContactMessageCountTask unreadCount:%d", new Object[]{Integer.valueOf(this.jiX.fnm)});
        if (this.jiX.fnm == -1) {
            this.jdJ.E(this.gOK, this.jiY.e("fail", null));
        } else {
            this.jdJ.E(this.gOK, this.jiY.e("ok", hashMap));
        }
        this.jiX.afj();
    }
}
