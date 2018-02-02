package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.mm.plugin.webview.fts.a.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.30;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class BaseSearchWebviewUI$2 implements a {
    final /* synthetic */ BaseSearchWebviewUI tCD;

    BaseSearchWebviewUI$2(BaseSearchWebviewUI baseSearchWebviewUI) {
        this.tCD = baseSearchWebviewUI;
    }

    public final void ef(int i, int i2) {
        if (BaseSearchWebviewUI.b(this.tCD) != null) {
            d c = BaseSearchWebviewUI.c(this.tCD);
            if (c.tGQ) {
                x.i("MicroMsg.JsApiHandler", "onSearchActionSheetClick success, ready");
                Map hashMap = new HashMap();
                hashMap.put("index", Integer.valueOf(i));
                hashMap.put("actionSheetId", Integer.valueOf(i2));
                ag.y(new 30(c, i.a.a("onSearchActionSheetClick", hashMap, c.tGS, c.tGT)));
                return;
            }
            x.e("MicroMsg.JsApiHandler", "onSearchActionSheetClick fail, not ready");
        }
    }
}
