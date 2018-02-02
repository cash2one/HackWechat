package com.tencent.mm.plugin.appbrand.jsapi.version;

import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.version.JsApiUpdateApp.SyncResult;
import com.tencent.mm.sdk.platformtools.ag;

class JsApiUpdateApp$1 implements i<SyncResult> {
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ JsApiUpdateApp jrF;

    JsApiUpdateApp$1(JsApiUpdateApp jsApiUpdateApp, j jVar, int i) {
        this.jrF = jsApiUpdateApp;
        this.iZy = jVar;
        this.gOK = i;
    }

    public final /* synthetic */ void as(Object obj) {
        SyncResult syncResult = (SyncResult) obj;
        if (!SyncResult.a(syncResult)) {
            this.iZy.E(this.gOK, this.jrF.e("fail sync error", null));
        } else if (this.iZy.irP.iqx.iOI.iGK == 0 && SyncResult.b(syncResult) == this.iZy.irP.iqx.iOI.iGL) {
            this.iZy.E(this.gOK, this.jrF.e("fail the current version is the latest version", null));
        } else {
            ag.y(new 1(this));
        }
    }
}
