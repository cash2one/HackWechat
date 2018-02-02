package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask$ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;

class JsApiPrivateAddContact$1 implements b<JsApiPrivateAddContact$AddContactResult> {
    final /* synthetic */ int gOK;
    final /* synthetic */ p jdJ;
    final /* synthetic */ JsApiPrivateAddContact jdK;

    JsApiPrivateAddContact$1(JsApiPrivateAddContact jsApiPrivateAddContact, p pVar, int i) {
        this.jdK = jsApiPrivateAddContact;
        this.jdJ = pVar;
        this.gOK = i;
    }

    public final /* synthetic */ void c(AppBrandProxyUIProcessTask$ProcessResult appBrandProxyUIProcessTask$ProcessResult) {
        x.i("MicroMsg.JsApiPrivateAddContact", "onReceiveResult resultCode:%d", new Object[]{Integer.valueOf(((JsApiPrivateAddContact$AddContactResult) appBrandProxyUIProcessTask$ProcessResult).bjW)});
        switch (((JsApiPrivateAddContact$AddContactResult) appBrandProxyUIProcessTask$ProcessResult).bjW) {
            case -2:
                this.jdJ.E(this.gOK, this.jdK.e("added", null));
                return;
            case -1:
                this.jdJ.E(this.gOK, this.jdK.e("fail", null));
                return;
            case 0:
                this.jdJ.E(this.gOK, this.jdK.e("cancel", null));
                return;
            case 1:
                this.jdJ.E(this.gOK, this.jdK.e("ok", null));
                return;
            default:
                return;
        }
    }
}
