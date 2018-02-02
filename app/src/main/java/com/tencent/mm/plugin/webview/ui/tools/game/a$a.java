package com.tencent.mm.plugin.webview.ui.tools.game;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.plugin.webview.ui.tools.widget.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.l;
import com.tencent.xweb.m;

class a$a extends b {
    final /* synthetic */ a tFo;

    public a$a(a aVar, MMWebView mMWebView) {
        this.tFo = aVar;
        super(mMWebView);
    }

    protected final void a(WebView webView, String str, Bitmap bitmap) {
        x.i("MicroMsg.GameFloatWebView", "onPageStarted opt, url = " + str);
        this.tFo.mZw.tFt.bUg();
        this.tFo.tFk.tLv.b(webView, str, bitmap);
    }

    protected final void e(WebView webView, String str) {
        x.i("MicroMsg.GameFloatWebView", "onPageFinished opt, url = %s", new Object[]{str});
        this.juE.setVisibility(0);
        this.tFo.tFk.tLv.a(webView, str);
        this.tFo.tFk.onDestroy();
        this.tFo.mZw.tFt.bUh();
    }

    protected final void a(d dVar, e eVar) {
        this.tFo.tFi = dVar;
    }

    protected final void a(com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar) {
        x.i("MicroMsg.GameFloatWebView", "jsapi ready");
        this.tFo.tFj = dVar;
    }

    protected final void a(f fVar) {
        x.i("MicroMsg.GameFloatWebView", "jsloader ready");
        this.tFo.tFm = fVar;
    }

    protected final boolean Pl(String str) {
        return this.tFo.tFk.PO(str);
    }

    protected final void BO(String str) {
        if (this.tFo.tFk.bUY()) {
            this.juE.loadUrl(str);
        } else {
            super.BO(str);
        }
    }

    protected final boolean Py(String str) {
        return super.Py(str);
    }

    protected final void Pz(String str) {
        try {
            x.i("MicroMsg.GameFloatWebView", "onURLFilteredOut url:%s", new Object[]{str});
            this.tFo.Fl.removeView(this.juE);
        } catch (Exception e) {
        }
    }

    protected final void bUe() {
        if (VERSION.SDK_INT >= 11) {
            this.juE.removeJavascriptInterface("MicroMsg");
            this.juE.removeJavascriptInterface("JsApi");
        }
        try {
            this.juE.setWebChromeClient(null);
            this.juE.setWebViewClient(null);
            this.juE.setOnTouchListener(null);
            this.juE.setOnLongClickListener(null);
            this.juE.setVisibility(8);
            this.juE.removeAllViews();
            this.juE.clearView();
        } catch (Exception e) {
            x.e("MicroMsg.GameFloatWebView", "onDestroy, set web infos to null,  ex = %s", new Object[]{e.getMessage()});
        }
        try {
            this.juE.destroy();
        } catch (Exception e2) {
            x.w("MicroMsg.GameFloatWebView", "onDestroy, viewWV destroy, ex = %s", new Object[]{e2.getMessage()});
        }
    }

    protected final g ahF() {
        return this.tFo.tFn;
    }

    public final m c(WebView webView, String str) {
        m c = this.tFo.tFk.tLv.c(webView, str);
        return c != null ? c : super.c(webView, str);
    }

    public final m a(WebView webView, l lVar) {
        m a = this.tFo.tFk.tLv.a(webView, lVar);
        return a != null ? a : super.a(webView, lVar);
    }

    public final m a(WebView webView, l lVar, Bundle bundle) {
        m a = this.tFo.tFk.tLv.a(webView, lVar, bundle);
        return a != null ? a : super.a(webView, lVar, bundle);
    }
}
