package com.tencent.mm.plugin.aj;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p;

class e$2 extends p {
    final /* synthetic */ e tjF;
    final /* synthetic */ MMWebView tjG;

    e$2(e eVar, MMWebView mMWebView) {
        this.tjF = eVar;
        this.tjG = mMWebView;
    }

    public final void a(WebView webView, String str) {
        x.i(this.tjF.TAG, "onPageFinished, view %s", new Object[]{webView.toString()});
        this.tjF.a(this.tjG);
    }

    public final void b(WebView webView, String str, Bitmap bitmap) {
        super.b(webView, str, bitmap);
        x.i(this.tjF.TAG, "onPageStarted, view %s", new Object[]{webView.toString()});
        f.a(this.tjG);
    }

    public final boolean b(WebView webView, String str) {
        if (!f.eE(str, "weixin://private/setresult/")) {
            return false;
        }
        x.i(this.tjF.TAG, "handleUrl %s ,view %s", new Object[]{str, webView.toString()});
        this.tjG.evaluateJavascript("javascript:WeixinJSBridge._continueSetResult()", null);
        return true;
    }
}
