package com.tencent.mm.plugin.game.gamewebview.e;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import com.tencent.mm.plugin.game.gamewebview.model.g;
import com.tencent.mm.plugin.webview.ui.tools.a;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;
import com.tencent.xweb.h;
import com.tencent.xweb.l;
import com.tencent.xweb.m;
import com.tencent.xweb.p;

class b$c extends p {
    final /* synthetic */ b naI;

    private b$c(b bVar) {
        this.naI = bVar;
    }

    public final void b(WebView webView, String str, Bitmap bitmap) {
        super.b(webView, str, bitmap);
        x.i("MicroMsg.GameWebView", "onPageStarted, url = %s", new Object[]{str});
        b.a(this.naI, false);
        if (!b.a(this.naI).BT(str) && b.b(this.naI) != null) {
            b.b(this.naI).b(webView, str, bitmap);
        }
    }

    public final void a(WebView webView, String str) {
        super.a(webView, str);
        x.i("MicroMsg.GameWebView", "onPageFinished, url = %s", new Object[]{str});
        b.c(this.naI);
        this.naI.postDelayed(new 1(this), 1000);
        b.d(this.naI);
        if (b.b(this.naI) != null) {
            b.b(this.naI).a(webView, str);
        }
        this.naI.postDelayed(new 2(this), 2000);
    }

    public final boolean b(WebView webView, String str) {
        x.i("MicroMsg.GameWebView", "shouldOverrideUrlLoading, url = %s, id = %d", new Object[]{str, Integer.valueOf(hashCode())});
        b.a(this.naI, false);
        if (b.a(this.naI).BT(str)) {
            return true;
        }
        if (b.b(this.naI) != null) {
            return b.b(this.naI).b(webView, str);
        }
        return super.b(webView, str);
    }

    public final void a(WebView webView, String str, boolean z) {
        x.i("MicroMsg.GameWebView", "doUpdateVisitedHistory, url = %s, isReload = %b", new Object[]{str, Boolean.valueOf(z)});
        super.a(webView, str, z);
        if (b.b(this.naI) != null) {
            b.b(this.naI).a(webView, str, z);
        }
    }

    @TargetApi(8)
    public final void a(WebView webView, h hVar, SslError sslError) {
        x.i("MicroMsg.GameWebView", "onReceivedSslError");
        if (b.b(this.naI) != null) {
            b.b(this.naI).a(webView, hVar, sslError);
        }
    }

    public final void a(WebView webView, int i, String str, String str2) {
        boolean isConnected = an.isConnected(b.f(this.naI));
        int Ax = a.Ax(i);
        x.i("MicroMsg.GameWebView", "onReceivedError, failingUrl = %s, errorCode = %d, errorKey = %d, desc = %s, isNetworkConnected = %b", new Object[]{str2, Integer.valueOf(i), Integer.valueOf(Ax), str, Boolean.valueOf(isConnected)});
        super.a(webView, i, str, str2);
        if (b.b(this.naI) != null) {
            b.b(this.naI).a(webView, i, str, str2);
        }
    }

    public final void f(WebView webView, String str) {
        x.i("MicroMsg.GameWebView", "onLoadResource opt, url = " + str);
        super.f(webView, str);
        if (!b.g(this.naI)) {
            b.a(this.naI, true);
            this.naI.fA(false);
        }
        if (b.b(this.naI) != null) {
            b.b(this.naI).f(webView, str);
        }
    }

    public final m c(WebView webView, String str) {
        x.i("MicroMsg.GameWebView", "shouldInterceptRequest, url = %s", new Object[]{str});
        b.h(this.naI);
        m BJ = g.BJ(str);
        if (BJ != null) {
            return BJ;
        }
        if (b.b(this.naI) != null) {
            return b.b(this.naI).c(webView, str);
        }
        return super.c(webView, str);
    }

    public final m a(WebView webView, l lVar) {
        x.i("MicroMsg.GameWebView", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", new Object[]{lVar.getUrl(), lVar.getMethod(), Boolean.valueOf(lVar.isForMainFrame())});
        if (lVar.getUrl() == null || bh.ov(lVar.getUrl().toString())) {
            return super.a(webView, lVar);
        }
        b.h(this.naI);
        m BJ = g.BJ(lVar.getUrl().toString());
        if (BJ != null) {
            return BJ;
        }
        if (b.b(this.naI) != null) {
            return b.b(this.naI).a(webView, lVar);
        }
        return super.a(webView, lVar);
    }

    public final m a(WebView webView, l lVar, Bundle bundle) {
        x.i("MicroMsg.GameWebView", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", new Object[]{lVar.getUrl(), lVar.getMethod(), Boolean.valueOf(lVar.isForMainFrame())});
        if (lVar.getUrl() == null || bh.ov(lVar.getUrl().toString())) {
            return super.a(webView, lVar);
        }
        b.h(this.naI);
        m BJ = g.BJ(lVar.getUrl().toString());
        if (BJ != null) {
            return BJ;
        }
        if (b.b(this.naI) != null) {
            return b.b(this.naI).a(webView, lVar, bundle);
        }
        return super.a(webView, lVar, bundle);
    }
}
