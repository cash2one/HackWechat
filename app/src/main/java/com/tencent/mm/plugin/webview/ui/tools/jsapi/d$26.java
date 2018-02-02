package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.sdk.platformtools.ak.a;
import org.json.JSONArray;
import org.json.JSONObject;

class d$26 implements a {
    final /* synthetic */ d tHd;

    d$26(d dVar) {
        this.tHd = dVar;
    }

    public final boolean uF() {
        d.d(this.tHd).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i.a.a("onBeaconsInRange", d.h(this.tHd), d.i(this.tHd), d.j(this.tHd)) + ")", null);
        d.k(this.tHd).clear();
        d.a(this.tHd, new JSONObject());
        d.a(this.tHd, new JSONArray());
        return false;
    }
}
