package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.text.TextUtils;
import com.tencent.mm.plugin.aj.a.f;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

class BaseSOSWebViewUI$17 implements Runnable {
    final /* synthetic */ BaseSOSWebViewUI tCm;

    BaseSOSWebViewUI$17(BaseSOSWebViewUI baseSOSWebViewUI) {
        this.tCm = baseSOSWebViewUI;
    }

    public final void run() {
        if (BaseSOSWebViewUI.k(this.tCm) != null) {
            Map hashMap = new HashMap();
            if (this.tCm.bTx() != 0) {
                hashMap.put("sugClickType", Integer.valueOf(this.tCm.bTx()));
                hashMap.put("sugId", this.tCm.bTw());
            }
            d l = BaseSOSWebViewUI.l(this.tCm);
            String bTC = this.tCm.bTC();
            String bTE = this.tCm.bTE();
            JSONArray bTF = this.tCm.bTF();
            Map hashMap2 = new HashMap();
            hashMap2.putAll(hashMap);
            hashMap2.put("query", bTC);
            hashMap2.put("custom", bTE);
            hashMap2.put("tagList", bTF);
            l.a("onSearchInputConfirm", hashMap2, null);
            if (!TextUtils.isEmpty(this.tCm.bTE())) {
                f.a(this.tCm.tCz, this.tCm.fqu, this.tCm.tjs, this.tCm.bTE(), this.tCm.tCA);
            }
        }
    }
}
