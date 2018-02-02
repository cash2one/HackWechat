package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import java.util.HashMap;
import java.util.Map;

class BaseSOSWebViewUI$14 implements Runnable {
    final /* synthetic */ BaseSOSWebViewUI tCm;

    BaseSOSWebViewUI$14(BaseSOSWebViewUI baseSOSWebViewUI) {
        this.tCm = baseSOSWebViewUI;
    }

    public final void run() {
        if (BaseSOSWebViewUI.e(this.tCm) != null) {
            d f = BaseSOSWebViewUI.f(this.tCm);
            int i = this.tCm.scene;
            Map hashMap = new HashMap();
            hashMap.put("isCancelButtonClick", Integer.valueOf(1));
            hashMap.put("isInputChange", Integer.valueOf(1));
            hashMap.put("scene", Integer.valueOf(i));
            f.a("onSearchInputChange", hashMap, null);
        }
    }
}
