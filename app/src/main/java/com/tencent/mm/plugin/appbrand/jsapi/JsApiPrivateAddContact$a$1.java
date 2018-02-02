package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.jsapi.JsApiPrivateAddContact.AddContactResult;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiPrivateAddContact.a;
import com.tencent.mm.pluginsdk.ui.applet.l;
import com.tencent.mm.sdk.platformtools.x;

class JsApiPrivateAddContact$a$1 implements l {
    final /* synthetic */ AddContactResult jdM;
    final /* synthetic */ a jdN;

    JsApiPrivateAddContact$a$1(a aVar, AddContactResult addContactResult) {
        this.jdN = aVar;
        this.jdM = addContactResult;
    }

    public final void kp(int i) {
        x.i("MicroMsg.JsApiPrivateAddContact", "onAddContact resultCode:%d", Integer.valueOf(i));
        AddContactResult.b(this.jdM);
        a.a(this.jdN, this.jdM);
    }
}
