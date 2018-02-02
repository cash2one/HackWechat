package com.tencent.mm.plugin.appbrand.jsapi.version;

import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.appbrand.jsapi.version.JsApiUpdateApp.1;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.widget.c.b;

class JsApiUpdateApp$1$1 implements Runnable {
    final /* synthetic */ 1 jrG;

    JsApiUpdateApp$1$1(1 1) {
        this.jrG = 1;
    }

    public final void run() {
        Object bVar = new b(this.jrG.iZy.getContext());
        bVar.setMessage(this.jrG.iZy.getContext().getString(this.jrG.iZy.irP.Yz() ? j.izT : j.izU, new Object[]{this.jrG.iZy.irP.iqw.frn}));
        OnClickListener 1 = new 1(this);
        if (this.jrG.iZy.irP.iqx.iOI.iGK != 0) {
            bVar.a(j.izS, 1);
            bVar.b(j.izQ, new 2(this));
        } else {
            bVar.a(j.izR, 1);
        }
        this.jrG.iZy.irP.a(bVar);
    }
}
