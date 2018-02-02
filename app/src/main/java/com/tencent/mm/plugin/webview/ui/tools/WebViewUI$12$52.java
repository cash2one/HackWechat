package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.12;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.17;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class WebViewUI$12$52 implements Runnable {
    final /* synthetic */ int fmb;
    final /* synthetic */ String hnj;
    final /* synthetic */ int jqi;
    final /* synthetic */ 12 tAx;
    final /* synthetic */ String tBd;
    final /* synthetic */ String tBe;
    final /* synthetic */ String tBf;

    WebViewUI$12$52(12 12, String str, int i, String str2, int i2, String str3, String str4) {
        this.tAx = 12;
        this.tBd = str;
        this.jqi = i;
        this.tBe = str2;
        this.fmb = i2;
        this.hnj = str3;
        this.tBf = str4;
    }

    public final void run() {
        if (this.tAx.tAv.tlx != null) {
            d dVar = this.tAx.tAv.tlx;
            String str = this.tBd;
            int i = this.jqi;
            String str2 = this.tBe;
            int i2 = this.fmb;
            String str3 = this.hnj;
            String str4 = this.tBf;
            if (dVar.tGQ) {
                x.i("MicroMsg.JsApiHandler", "onBackgroundAudioStateChange, state : %s, duration : %d, src:%s, errCode:%d, errMsg:%s, srcId:%s", new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2), str3, str4});
                Map hashMap = new HashMap();
                hashMap.put("state", str);
                hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(i));
                hashMap.put("src", str2);
                hashMap.put("errCode", Integer.valueOf(i2));
                hashMap.put("errMsg", str3);
                hashMap.put("srcId ", str4);
                ag.y(new 17(dVar, a.a("onBackgroundAudioStateChange", hashMap, dVar.tGS, dVar.tGT)));
                return;
            }
            x.e("MicroMsg.JsApiHandler", "onBackgroundAudioStateChange fail, not ready");
        }
    }
}
