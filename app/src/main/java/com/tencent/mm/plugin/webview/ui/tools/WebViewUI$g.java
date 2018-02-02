package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.d;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

class WebViewUI$g implements b {
    final /* synthetic */ WebViewUI tAv;

    private WebViewUI$g(WebViewUI webViewUI) {
        this.tAv = webViewUI;
    }

    public final boolean BT(String str) {
        if (bh.ov(str)) {
            return false;
        }
        return s.eE(str, "weixin://");
    }

    public final boolean BU(String str) {
        int b = WebViewUI.b(this.tAv, bh.ou(WebViewUI.aQ(this.tAv)));
        if (!d.ae(str, WebViewUI.aR(this.tAv))) {
            return false;
        }
        try {
            if ("weixin://dl/shopping".equals(str)) {
                String bRT = this.tAv.juQ.bRT();
                if (!bh.ov(bRT)) {
                    this.tAv.ptK.loadUrl(bRT);
                }
            } else if ("weixin://dl/faq".equals(str)) {
                int bRV = this.tAv.juQ.bRV();
                int bRW = this.tAv.juQ.bRW();
                this.tAv.ptK.loadUrl(ac.getContext().getString(R.l.eNr, new Object[]{Integer.valueOf(bRV), Integer.valueOf(bRW)}));
            } else if ("weixin://dl/posts".equals(str)) {
                this.tAv.juQ.bRX();
            } else if ("weixin://dl/moments".equals(str)) {
                this.tAv.juQ.bRY();
            } else if (str.startsWith("weixin://dl/feedback")) {
                this.tAv.juQ.OW(str);
            } else if ("weixin://dl/scan".equals(str)) {
                com.tencent.mm.bm.d.a(this.tAv, "scanner", ".ui.SingleTopScanUI", new Intent(), false);
            } else {
                d.Rh(str);
            }
            List arrayList = new ArrayList();
            arrayList.add(str);
            arrayList.add("1");
            arrayList.add(String.valueOf(b));
            arrayList.add(bh.ou(WebViewUI.aQ(this.tAv)));
            arrayList.add(bh.ou(this.tAv.fIG));
            this.tAv.juQ.f(11405, arrayList);
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.WebViewUI", "kv report fail, ex = %s", e.getMessage());
            return true;
        }
    }
}
