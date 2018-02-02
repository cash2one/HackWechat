package com.tencent.mm.plugin.game.gamewebview.ui;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import com.tencent.mm.plugin.game.gamewebview.d.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.model.aa;
import com.tencent.mm.plugin.webview.ui.tools.b;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.h;
import com.tencent.xweb.l;
import com.tencent.xweb.m;
import com.tencent.xweb.p;

class d$33 extends p {
    final /* synthetic */ d mZC;

    d$33(d dVar) {
        this.mZC = dVar;
    }

    public final void b(WebView webView, String str, Bitmap bitmap) {
        d.g(this.mZC).tFt.bUg();
        if (aa.Oj(str)) {
            d.a(this.mZC, str);
            if (this.mZC.aPg()) {
                this.mZC.aPi();
            } else {
                this.mZC.aPj();
            }
            d.a(this.mZC, str, false);
            d.h(this.mZC).bSu();
            d.h(this.mZC).Pk(str);
            if (!(d.i(this.mZC) == null || d.i(this.mZC).tLv == null)) {
                d.i(this.mZC).tLv.b(webView, str, bitmap);
            }
            a j = d.j(this.mZC);
            j.mYd = false;
            j.mYi = System.currentTimeMillis();
            g.pQN.a(606, 0, 1, false);
            g.pQN.a(611, 2, 1, false);
            return;
        }
        x.i("MicroMsg.GameWebPageView", "onPageStarted canLoadUrl fail, url = %s", new Object[]{str});
    }

    public final boolean b(WebView webView, String str) {
        x.i("MicroMsg.GameWebPageView", "shouldOverrideUrlLoading, url = %s, id = %d", new Object[]{str, Integer.valueOf(hashCode())});
        if (!aa.Oj(str)) {
            x.f("MicroMsg.GameWebPageView", "shouldOverrideUrlLoading, canLoadUrl fail, url = " + str);
            d.k(this.mZC);
            return true;
        } else if (s.eE(str, "about:blank")) {
            x.e("MicroMsg.GameWebPageView", "shouldOverride, url is about:blank");
            return true;
        } else if (str.startsWith("weixin://")) {
            x.e("MicroMsg.GameWebPageView", "shouldOverrideUrlLoading, can not deal with this weixin scheme, stop directly, url = %s", new Object[]{str});
            return true;
        } else if (str.startsWith("weixinping://iframe") || str.startsWith("weixinpreinject://iframe")) {
            return true;
        } else {
            if (d.b(this.mZC, str)) {
                x.i("MicroMsg.GameWebPageView", "custom scheme url deal success, url = " + str);
                return true;
            }
            int BI = d.l(this.mZC).mXM.BI(str);
            boolean z = d.m(this.mZC).getBoolean("neverGetA8Key", false);
            if ((BI == 0 || BI == 2) && !z) {
                x.i("MicroMsg.GameWebPageView", "edw shouldOverride, should not continue, reason = " + BI);
                if (this.mZC.aPg()) {
                    d.n(this.mZC).stopLoading();
                    d.n(this.mZC).post(new 1(this, str));
                } else {
                    d.n(this.mZC).stopLoading();
                }
                if (!str.equals(d.f(this.mZC))) {
                    d.a(this.mZC, str, true);
                    return true;
                }
            }
            x.w("MicroMsg.GameWebPageView", "shouldOverride, url equals lastGetA8KeyUrl, not trigger geta8key");
            return super.b(webView, str);
        }
    }

    public final void a(WebView webView, String str) {
        d.o(this.mZC).setVisibility(8);
        if (aa.Oj(str)) {
            d.h(this.mZC).Pk(this.mZC.aPk());
            d.p(this.mZC).finish();
            if (!(d.i(this.mZC) == null || d.i(this.mZC).tLv == null)) {
                d.i(this.mZC).tLv.a(webView, str);
            }
            a j = d.j(this.mZC);
            x.d("MicroMsg.GameWebViewReportManager", "loadTime = %d", new Object[]{Long.valueOf(System.currentTimeMillis() - j.mYi)});
            j.mYc = 1;
            j.a(j.mWG.aPk(), 2, r4, j.mYc, 0);
            g.pQN.a(611, 3, 1, false);
            if (d.q(this.mZC) != null) {
                d.q(this.mZC).ajQ();
            }
            d.g(this.mZC).tFt.bUh();
            return;
        }
        x.f("MicroMsg.GameWebPageView", "onPageFinished, canLoadUrl fail, url = " + str);
        d.k(this.mZC);
    }

    public final void a(WebView webView, String str, boolean z) {
        x.i("MicroMsg.GameWebPageView", "doUpdateVisitedHistory, url = %s, isReload = %b", new Object[]{str, Boolean.valueOf(z)});
        d.a(this.mZC, webView.getUrl(), false);
        d.a(this.mZC, str);
    }

    @TargetApi(8)
    public final void a(WebView webView, h hVar, SslError sslError) {
        String r = webView.getUrl() == null ? d.r(this.mZC) : webView.getUrl();
        d.j(this.mZC).mYc = 0;
        g.pQN.a(606, 2, 1, false);
        d.o(this.mZC).setVisibility(8);
        if (d.s(this.mZC) == null) {
            d.a(this.mZC, new b(d.t(this.mZC), d.n(this.mZC)));
        }
        d.s(this.mZC).a(r, hVar, sslError);
    }

    public final void a(WebView webView, int i, String str, String str2) {
        a j = d.j(this.mZC);
        j.mYc = 0;
        g.pQN.a(606, 1, 1, false);
        g.pQN.a(606, (long) com.tencent.mm.plugin.webview.ui.tools.a.Ax(i), 1, false);
        j.a(str2, 6, 0, j.mYc, i);
    }

    public final void f(WebView webView, String str) {
        if (aa.Oj(str)) {
            a j = d.j(this.mZC);
            if (!j.mYd) {
                j.mYd = true;
                x.d("MicroMsg.GameWebViewReportManager", "domReadyTime = %d", new Object[]{Long.valueOf(System.currentTimeMillis() - j.mYi)});
                j.a(j.mWG.aPk(), 5, r4, j.mYc, 0);
                return;
            }
            return;
        }
        d.k(this.mZC);
    }

    public final m c(WebView webView, String str) {
        if (!(d.i(this.mZC) == null || d.i(this.mZC).tLv == null)) {
            m c = d.i(this.mZC).tLv.c(webView, str);
            if (c != null) {
                return c;
            }
        }
        return super.c(webView, str);
    }

    public final m a(WebView webView, l lVar) {
        if (!(d.i(this.mZC) == null || d.i(this.mZC).tLv == null)) {
            m a = d.i(this.mZC).tLv.a(webView, lVar);
            if (a != null) {
                return a;
            }
        }
        return super.a(webView, lVar);
    }

    public final m a(WebView webView, l lVar, Bundle bundle) {
        if (lVar == null || lVar.getUrl() == null || bh.ov(lVar.getUrl().toString())) {
            return super.a(webView, lVar);
        }
        if (!(d.i(this.mZC) == null || d.i(this.mZC).tLv == null)) {
            m a = d.i(this.mZC).tLv.a(webView, lVar, bundle);
            if (a != null) {
                return a;
            }
        }
        if (WebView.getCurWebType() != c.AqC || WebView.getTbsCoreVersion(d.t(this.mZC)) > 36541) {
            try {
                int i = bundle.getInt("resourceType");
                if (i == 1 || i == 7) {
                    x.i("MicroMsg.GameWebPageView", "get resoutce type is iframe : %d, start geta8key", new Object[]{Integer.valueOf(i)});
                    d.c(this.mZC, lVar.getUrl().toString());
                }
            } catch (Exception e) {
                x.w("MicroMsg.GameWebPageView", "get resource type failed Exception ; %s", new Object[]{e.getMessage()});
            } catch (Throwable th) {
                x.w("MicroMsg.GameWebPageView", "get resource type failed Throwable ; %s", new Object[]{th.getMessage()});
            }
        }
        return super.a(webView, lVar);
    }
}
