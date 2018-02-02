package com.tencent.mm.plugin.webview.wepkg;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.plugin.webview.wepkg.utils.a;
import com.tencent.mm.plugin.webview.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;
import com.tencent.xweb.l;
import com.tencent.xweb.m;
import com.tencent.xweb.p;

public class a$c extends p {
    final /* synthetic */ a tLy;

    public a$c(a aVar) {
        this.tLy = aVar;
    }

    public final void b(WebView webView, String str, Bitmap bitmap) {
        x.d("MicroMsg.Wepkg.WePkgPlugin", "onPageStarted, url = %s", new Object[]{str});
        a.a(this.tLy, System.currentTimeMillis());
        a.a(this.tLy, this.tLy.PO(str));
        super.b(webView, str, bitmap);
    }

    public final void a(WebView webView, String str) {
        x.d("MicroMsg.Wepkg.WePkgPlugin", "onPageFinished, url = %s", new Object[]{str});
        if (a.i(this.tLy) != 0) {
            long currentTimeMillis = System.currentTimeMillis() - a.i(this.tLy);
            String Qq = d.Qq(str);
            if (bh.ov(Qq)) {
                a.b("PageLoadTime", str, "", null, 2, currentTimeMillis, null);
            } else if (!a.j(this.tLy) || a.g(this.tLy) == null) {
                a.b("PageLoadTime", str, Qq, null, 0, currentTimeMillis, null);
            } else {
                a.b("PageLoadTime", str, a.g(this.tLy).tNm, a.g(this.tLy).version, 1, currentTimeMillis, null);
            }
            a.a(this.tLy, 0);
        }
        if (a.j(this.tLy) && a.k(this.tLy) != null) {
            if ((a.k(this.tLy).Qc(d.Qs(a.b(this.tLy))) != null ? 1 : null) != null) {
                x.i("MicroMsg.Wepkg.WePkgPlugin", "startTimer");
                a.l(this.tLy).J(1000, 1000);
            }
        }
        a.a(this.tLy, this.tLy.PO(str));
        super.a(webView, str);
    }

    public final m c(WebView webView, String str) {
        if (!a.j(this.tLy)) {
            return null;
        }
        m Qc;
        if (a.k(this.tLy) != null) {
            Qc = a.k(this.tLy).Qc(d.Qs(str));
        } else {
            Qc = null;
        }
        if (Qc == null) {
            return null;
        }
        x.i("MicroMsg.Wepkg.WePkgPlugin", "shouldInterceptRequest, url = %s", new Object[]{str});
        if (a.g(this.tLy) != null) {
            a.b("RequestHook", str, a.g(this.tLy).tNm, a.g(this.tLy).version, 1, 0, null);
        }
        return Qc;
    }

    public final m a(WebView webView, l lVar) {
        if (lVar == null || lVar.getUrl() == null || bh.ov(lVar.getUrl().toString()) || !a.j(this.tLy)) {
            return null;
        }
        m Qc;
        if (a.k(this.tLy) != null) {
            Qc = a.k(this.tLy).Qc(d.Qs(lVar.getUrl().toString()));
        } else {
            Qc = null;
        }
        if (Qc == null) {
            return null;
        }
        x.i("MicroMsg.Wepkg.WePkgPlugin", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", new Object[]{lVar.getUrl(), lVar.getMethod(), Boolean.valueOf(lVar.isForMainFrame())});
        if (a.g(this.tLy) != null) {
            a.b("RequestHook", lVar.getUrl().toString(), a.g(this.tLy).tNm, a.g(this.tLy).version, 1, 0, null);
        }
        return Qc;
    }

    public final m a(WebView webView, l lVar, Bundle bundle) {
        if (lVar == null || lVar.getUrl() == null || bh.ov(lVar.getUrl().toString()) || !a.j(this.tLy)) {
            return null;
        }
        m Qc;
        if (a.k(this.tLy) != null) {
            Qc = a.k(this.tLy).Qc(d.Qs(lVar.getUrl().toString()));
        } else {
            Qc = null;
        }
        if (Qc == null) {
            return null;
        }
        x.i("MicroMsg.Wepkg.WePkgPlugin", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", new Object[]{lVar.getUrl(), lVar.getMethod(), Boolean.valueOf(lVar.isForMainFrame())});
        if (a.g(this.tLy) != null) {
            a.b("RequestHook", lVar.getUrl().toString(), a.g(this.tLy).tNm, a.g(this.tLy).version, 1, 0, null);
        }
        return Qc;
    }
}
