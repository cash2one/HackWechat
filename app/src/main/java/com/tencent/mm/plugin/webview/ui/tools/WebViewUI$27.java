package com.tencent.mm.plugin.webview.ui.tools;

import android.net.Uri;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.webview.model.ag;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i$a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

class WebViewUI$27 implements a {
    final /* synthetic */ WebViewUI tAv;

    WebViewUI$27(WebViewUI webViewUI) {
        this.tAv = webViewUI;
    }

    public final void bTk() {
        int T;
        int i = 2;
        boolean z = false;
        try {
            if (this.tAv.juQ.aOD()) {
                if (this.tAv.bSV() || this.tAv.bSW()) {
                    T = WebViewUI.T(this.tAv);
                    if (T > 0 && T <= 4) {
                        i = T;
                    }
                    WebViewUI.d(this.tAv, i);
                    this.tAv.J(true, true);
                    if (this.tAv.ptK != null && this.tAv.juR != null && this.tAv.tlx != null) {
                        String url = this.tAv.ptK.getUrl();
                        if (!bh.ov(url) && WebViewUI.U(this.tAv).add(url)) {
                            GeneralControlWrapper bSt = this.tAv.juR.bSt();
                            boolean z2 = (bSt.vAL & WXMediaMessage.TITLE_LENGTH_LIMIT) > 0;
                            x.d("MicroMsg.GeneralControlWrapper", "allowUploadHosts, ret = " + z2);
                            if (z2) {
                                d dVar = this.tAv.tlx;
                                x.i("MicroMsg.JsApiHandler", "getAllHostsInPage, ready(%s).", new Object[]{Boolean.valueOf(dVar.tGQ)});
                                if (dVar.tGK != null && dVar.tGQ) {
                                    dVar.tGK.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i$a.a("sys:get_all_hosts", new HashMap(), dVar.tGS, dVar.tGT) + ")", null);
                                }
                            }
                            if ((bSt.vAL & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) > 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            x.d("MicroMsg.GeneralControlWrapper", "allowUploadHTML, ret = " + z2);
                            if (z2) {
                                this.tAv.tlx.kB(false);
                                return;
                            }
                            ag n = WebViewUI.n(this.tAv);
                            if (!bh.ov(url)) {
                                url = Uri.parse(url).getHost();
                                if (!bh.ov(url)) {
                                    z = n.tsC.remove(url);
                                }
                            }
                            if (z) {
                                this.tAv.tlx.kB(true);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                } else if (bh.ov(this.tAv.fIG) || !com.tencent.mm.plugin.webview.a.tkS.matcher(this.tAv.fIG).matches()) {
                    T = this.tAv.juQ.ek(16384, 2);
                    i = T;
                    WebViewUI.d(this.tAv, i);
                    this.tAv.J(true, true);
                    if (this.tAv.ptK != null) {
                    }
                } else {
                    T = this.tAv.juQ.ek(16388, 2);
                    i = T;
                    WebViewUI.d(this.tAv, i);
                    this.tAv.J(true, true);
                    if (this.tAv.ptK != null) {
                    }
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.WebViewUI", "onLoadJsApiFinished, ex = " + e.getMessage());
        }
        T = 2;
        i = T;
        WebViewUI.d(this.tAv, i);
        this.tAv.J(true, true);
        if (this.tAv.ptK != null) {
        }
    }
}
