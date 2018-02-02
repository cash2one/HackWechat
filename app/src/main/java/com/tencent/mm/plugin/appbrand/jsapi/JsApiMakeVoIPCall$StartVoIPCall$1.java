package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.g.a.qt;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall.StartVoIPCall;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class JsApiMakeVoIPCall$StartVoIPCall$1 extends c<qt> {
    final /* synthetic */ StartVoIPCall jdu;

    JsApiMakeVoIPCall$StartVoIPCall$1(StartVoIPCall startVoIPCall) {
        this.jdu = startVoIPCall;
        this.xen = qt.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        qt qtVar = (qt) bVar;
        if (qtVar != null && (qtVar instanceof qt)) {
            this.jdu.status = qtVar.fIB.status;
            a.xef.c(StartVoIPCall.a(this.jdu));
            StartVoIPCall.b(this.jdu);
        }
        return false;
    }
}
