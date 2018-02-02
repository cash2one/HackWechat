package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiAddNativeDownloadTask.AddNativeDownloadTaskTask;
import java.util.HashMap;
import java.util.Map;

class JsApiAddNativeDownloadTask$4 implements Runnable {
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ JsApiAddNativeDownloadTask jcF;
    final /* synthetic */ AddNativeDownloadTaskTask jcG;

    JsApiAddNativeDownloadTask$4(JsApiAddNativeDownloadTask jsApiAddNativeDownloadTask, AddNativeDownloadTaskTask addNativeDownloadTaskTask, j jVar, int i) {
        this.jcF = jsApiAddNativeDownloadTask;
        this.jcG = addNativeDownloadTaskTask;
        this.iZy = jVar;
        this.gOK = i;
    }

    public final void run() {
        this.jcG.afj();
        Map hashMap = new HashMap();
        switch (this.jcG.fDt) {
            case 0:
                this.iZy.E(this.gOK, this.jcF.e("fail:cancel", null));
                return;
            case 1:
                this.iZy.E(this.gOK, this.jcF.e("fail:download fail", null));
                return;
            case 2:
                hashMap.put("download_id", Long.valueOf(this.jcG.fmZ));
                this.iZy.E(this.gOK, this.jcF.e("ok", hashMap));
                return;
            default:
                return;
        }
    }
}
