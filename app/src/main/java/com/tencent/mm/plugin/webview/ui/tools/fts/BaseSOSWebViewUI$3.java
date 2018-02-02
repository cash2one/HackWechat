package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.41;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class BaseSOSWebViewUI$3 implements Runnable {
    final /* synthetic */ String jLQ;
    final /* synthetic */ BaseSOSWebViewUI tCm;
    final /* synthetic */ Bundle tCn;
    final /* synthetic */ boolean tCo;
    final /* synthetic */ String tnb;

    BaseSOSWebViewUI$3(BaseSOSWebViewUI baseSOSWebViewUI, Bundle bundle, String str, boolean z, String str2) {
        this.tCm = baseSOSWebViewUI;
        this.tCn = bundle;
        this.jLQ = str;
        this.tCo = z;
        this.tnb = str2;
    }

    public final void run() {
        if (BaseSOSWebViewUI.q(this.tCm) == null) {
            return;
        }
        if (this.tCn == null || this.tCn.getInt("isRefresh") != 1 || this.tCn.getString("widgetId") == null) {
            BaseSOSWebViewUI.s(this.tCm).b(this.jLQ, this.tCo, this.tnb);
            return;
        }
        d r = BaseSOSWebViewUI.r(this.tCm);
        String string = this.tCn.getString("widgetId");
        String str = this.jLQ;
        if (r.tGQ) {
            x.i("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadDataFinish success, ready");
            Map hashMap = new HashMap();
            hashMap.put("widgetId", string);
            hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, str);
            ag.y(new 41(r, a.a("onSearchWAWidgetReloadDataFinish", hashMap, r.tGS, r.tGT)));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadDataFinish fail, not ready");
    }
}
