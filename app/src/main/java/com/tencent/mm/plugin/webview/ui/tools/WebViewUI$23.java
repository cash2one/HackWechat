package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.mm.g.a.ow;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$23 extends c<ow> {
    final /* synthetic */ WebViewUI tAv;

    WebViewUI$23(WebViewUI webViewUI) {
        this.tAv = webViewUI;
        this.xen = ow.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        return bTi();
    }

    private boolean bTi() {
        if (this.tAv.juQ == null) {
            x.e("MicroMsg.WebViewUI", "Cli Event, invoker is null");
        } else if (WebViewUI.z(this.tAv) == null || WebViewUI.z(this.tAv).length() == 0) {
            x.e("MicroMsg.WebViewUI", "Cli Event, tid is null");
        } else {
            try {
                x.i("MicroMsg.WebViewUI", "Cli Event, tid = %s, stime = %d, etime = %d", new Object[]{WebViewUI.z(this.tAv), Long.valueOf(WebViewUI.A(this.tAv)), Long.valueOf(System.currentTimeMillis())});
                Bundle bundle = new Bundle();
                bundle.putString("service_click_tid", new String(WebViewUI.z(this.tAv)));
                bundle.putLong("service_click_stime", WebViewUI.A(this.tAv));
                bundle.putLong("service_click_etime", r0);
                this.tAv.juQ.r(2836, bundle);
            } catch (Exception e) {
                x.e("MicroMsg.WebViewUI", "Cli Event Exception, msg = %s", new Object[]{e.getMessage()});
            }
            WebViewUI.a(this.tAv, null);
        }
        return false;
    }
}
