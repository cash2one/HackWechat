package com.tencent.mm.plugin.appbrand.jsapi.version;

import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.r$b;
import com.tencent.mm.plugin.appbrand.jsapi.version.JsApiUpdateApp.a;

class JsApiUpdateApp$a$1 implements r$b<WxaAttributes> {
    final /* synthetic */ i gMv;
    final /* synthetic */ a jrI;

    JsApiUpdateApp$a$1(a aVar, i iVar) {
        this.jrI = aVar;
        this.gMv = iVar;
    }

    public final /* synthetic */ void d(int i, Object obj) {
        WxaAttributes wxaAttributes = (WxaAttributes) obj;
        switch (i) {
            case 1:
            case 2:
                this.gMv.as(new JsApiUpdateApp$SyncResult(true, wxaAttributes.acb().fIm));
                return;
            case 3:
                this.gMv.as(new JsApiUpdateApp$SyncResult(false, -1));
                return;
            default:
                return;
        }
    }
}
