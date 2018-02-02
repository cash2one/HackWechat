package com.tencent.mm.plugin.appbrand.jsapi;

import android.net.Uri;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode.1;
import com.tencent.mm.sdk.platformtools.bh;
import java.net.URLDecoder;
import java.util.HashMap;

class JsApiScanCode$1$1 implements Runnable {
    final /* synthetic */ JsApiScanCode$GetA8KeyTask jdX;
    final /* synthetic */ HashMap jdY;
    final /* synthetic */ 1 jdZ;

    JsApiScanCode$1$1(1 1, JsApiScanCode$GetA8KeyTask jsApiScanCode$GetA8KeyTask, HashMap hashMap) {
        this.jdZ = 1;
        this.jdX = jsApiScanCode$GetA8KeyTask;
        this.jdY = hashMap;
    }

    public final void run() {
        this.jdX.afj();
        if (this.jdX.actionCode == 26) {
            Uri parse = Uri.parse(this.jdX.jeb);
            if (this.jdZ.iZy.irP.iqx.fnl.equals(parse.getQueryParameter("username"))) {
                this.jdY.put("path", URLDecoder.decode(bh.ou(parse.getQueryParameter("path"))));
            }
        }
        this.jdZ.iZy.E(this.jdZ.gOK, this.jdZ.jdW.e("ok", this.jdY));
    }
}
