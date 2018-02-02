package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.33;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;
import java.util.Map;

public final class f {
    private static String tHn = "window.addEventListener('load', requestInjectJS, false); function requestInjectJS() { console.log('weixin://preInjectJSBridge/start');}";
    private d juQ;
    public boolean tEd;
    private a tHk;
    private boolean tHl;
    private final ak tHm;
    private d tlx;
    private WebView twx;

    static /* synthetic */ void b(f fVar) {
        boolean z;
        if (fVar.tEd) {
            x.i("MicroMsg.JsLoader", "jsapi init done by preload");
            if (fVar.tlx != null) {
                fVar.tlx.bUn();
            }
            z = true;
        } else if (fVar.twx == null || fVar.tlx == null) {
            x.e("MicroMsg.JsLoader", "loadJavaScript build, viewWV is null");
            z = false;
        } else {
            Map bTU;
            fVar.twx.evaluateJavascript(fVar.bUu(), new 1(fVar));
            d dVar = fVar.tlx;
            x.v("MicroMsg.JsApiHandler", "jsapi init");
            dVar.tGK.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i$a.a("sys:init", dVar.tGO, dVar.tGS, dVar.tGT) + ")", new ValueCallback<String>(dVar) {
                final /* synthetic */ d tHd;

                {
                    this.tHd = r1;
                }

                public final /* synthetic */ void onReceiveValue(Object obj) {
                    x.i("MicroMsg.JsApiHandler", "sys:init back %s\t", new Object[]{(String) obj});
                }
            });
            dVar.tGK.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i$a.a("sys:bridged", null, dVar.tGS, dVar.tGT) + ")", new 33(dVar));
            dVar.bUn();
            dVar.bUo();
            if (!(bh.ov(dVar.tGW) || dVar.tGK == null)) {
                dVar.tGK.evaluateJavascript(dVar.cI(dVar.tGW, dVar.tGX), null);
                dVar.tGW = null;
                dVar.tGX = 0;
            }
            if (dVar.tGK.getContext() instanceof MutableContextWrapper) {
                Context baseContext = ((MutableContextWrapper) dVar.tGK.getContext()).getBaseContext();
                if (baseContext instanceof PreLoadWebViewUI) {
                    bTU = ((PreLoadWebViewUI) baseContext).bTU();
                    dVar.al(bTU);
                    x.i("MicroMsg.JsLoader", "jsapi init done");
                    z = true;
                } else {
                    x.i("MicroMsg.JsApiHandler", "webview.context is not PreloadWebviewUI， %s", new Object[]{baseContext.toString()});
                }
            }
            bTU = null;
            dVar.al(bTU);
            x.i("MicroMsg.JsLoader", "jsapi init done");
            z = true;
        }
        x.i("MicroMsg.JsLoader", "onTimerExpired, js loaded ret = %b", new Object[]{Boolean.valueOf(z)});
        if (z && fVar.tHk != null) {
            fVar.tHk.bTk();
        }
        g.pQN.a(156, 1, 1, false);
        if (!z) {
            g.pQN.a(156, 0, 1, false);
        }
    }

    public f(WebView webView, d dVar, d dVar2, a aVar, boolean z) {
        this(webView, dVar, dVar2, aVar, false, false);
    }

    public f(WebView webView, d dVar, d dVar2, a aVar, boolean z, boolean z2) {
        this.tHl = false;
        this.tHm = new ak(new 2(this), true);
        this.twx = webView;
        this.juQ = dVar;
        this.tlx = dVar2;
        this.tHk = aVar;
        this.tHl = z;
        this.tEd = z2;
        x.d("MicroMsg.JsLoader", "JsLoader <init>, withoutDelay = %b,isWebViewPreload %b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
    }

    public final void detach() {
        x.v("MicroMsg.JsLoader", "detach");
        this.twx = null;
        this.tlx = null;
        this.tHk = null;
    }

    public final void bUg() {
        x.v("MicroMsg.JsLoader", "onPageStarted");
        if (!this.tHm.cfK()) {
            this.tHm.TG();
            x.i("MicroMsg.JsLoader", "tryStopTimer success");
        }
    }

    public final void bUh() {
        x.v("MicroMsg.JsLoader", "onPageFinished");
        if (this.tHm.cfK()) {
            ak akVar = this.tHm;
            long j = this.tHl ? 0 : 1000;
            akVar.J(j, j);
            x.i("MicroMsg.JsLoader", "tryStartTimer success");
            return;
        }
        x.i("MicroMsg.JsLoader", "timer running");
    }

    private String bUu() {
        int i;
        try {
            if (this.juQ.e(98, null) == null) {
                i = 0;
            } else {
                i = 1;
            }
        } catch (Exception e) {
            i = 0;
        }
        x.i("MicroMsg.JsLoader", "WXJS: %s", new Object[]{i != 0 ? "jsapi/wxjs.js" : "jsapi/wxjs_fallback.js"});
        try {
            String convertStreamToString = bh.convertStreamToString(ac.getContext().getAssets().open(i != 0 ? "jsapi/wxjs.js" : "jsapi/wxjs_fallback.js"));
            if (TextUtils.isEmpty(this.tlx.tGT)) {
                return convertStreamToString;
            }
            return convertStreamToString.replace("__wx._getDgtVerifyRandomStr()", this.tlx.tGT).replace("__wx._isDgtVerifyEnabled()", "true");
        } catch (Exception e2) {
            x.e("MicroMsg.JsLoader", "tryInterceptBridgeScriptRequest, failed, ", new Object[]{e2});
            return "";
        }
    }
}
