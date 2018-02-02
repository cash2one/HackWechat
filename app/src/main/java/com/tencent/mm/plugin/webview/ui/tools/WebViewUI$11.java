package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.a;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.HashMap;
import java.util.Map;

class WebViewUI$11 implements a {
    final /* synthetic */ WebViewUI tAv;

    WebViewUI$11(WebViewUI webViewUI) {
        this.tAv = webViewUI;
    }

    public final boolean uX(String str) {
        if (this.tAv.tlx != null) {
            d dVar = this.tAv.tlx;
            Map hashMap = new HashMap();
            hashMap.put("smiley", str);
            ag.y(new d$21(dVar, i.a.a("onGetSmiley", hashMap, dVar.tGS, dVar.tGT)));
        }
        return true;
    }
}
