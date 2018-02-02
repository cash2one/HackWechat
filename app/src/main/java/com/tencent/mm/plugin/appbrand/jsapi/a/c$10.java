package com.tencent.mm.plugin.appbrand.jsapi.a;

import com.tencent.mm.plugin.af.a.a;
import com.tencent.mm.sdk.platformtools.x;

class c$10 implements a {
    final /* synthetic */ c jgI;

    c$10(c cVar) {
        this.jgI = cVar;
    }

    public final void si(String str) {
        x.i("MicroMsg.JsApiGetPhoneNumber", "smsListener onchange");
        x.d("MicroMsg.JsApiGetPhoneNumber", "smsVerifyCode:%s", new Object[]{str});
        this.jgI.jgz.setText(str);
    }
}
