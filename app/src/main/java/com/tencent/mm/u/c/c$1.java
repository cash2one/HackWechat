package com.tencent.mm.u.c;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.u.b.b$a;

class c$1 implements b$a {
    final /* synthetic */ int gOK;
    final /* synthetic */ c gOL;

    c$1(c cVar, int i) {
        this.gOL = cVar;
        this.gOK = i;
    }

    public final void aw(Object obj) {
        e eVar = this.gOL.gOG.gOM;
        int i = this.gOK;
        String obj2 = obj == null ? "" : obj.toString();
        if (bh.ov(obj2)) {
            obj2 = "{}";
        }
        eVar.gOS.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.invokeCallbackHandler(%d, %s)", new Object[]{Integer.valueOf(i), obj2}), null);
    }
}
