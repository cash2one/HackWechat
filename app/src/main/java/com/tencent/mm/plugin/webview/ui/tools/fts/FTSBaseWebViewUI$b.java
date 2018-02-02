package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.bc.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;
import com.tencent.xweb.l;
import com.tencent.xweb.m;
import java.io.InputStream;

class FTSBaseWebViewUI$b extends a {
    final /* synthetic */ FTSBaseWebViewUI tCF;

    private FTSBaseWebViewUI$b(FTSBaseWebViewUI fTSBaseWebViewUI) {
        this.tCF = fTSBaseWebViewUI;
        super(fTSBaseWebViewUI);
    }

    public final void a(WebView webView, String str) {
        super.a(webView, str);
        x.i("MicroMsg.FTS.FTSBaseWebViewUI", "onPageFinished %s", new Object[]{str});
        this.tCF.showOptionMenu(false);
        if (FTSBaseWebViewUI.i(this.tCF) != null && !FTSBaseWebViewUI.j(this.tCF)) {
            FTSBaseWebViewUI.bTz();
            FTSBaseWebViewUI.i(this.tCF).zet.yig.clearFocus();
            this.tCF.aWs();
        }
    }

    public final void b(WebView webView, String str, Bitmap bitmap) {
        super.b(webView, str, bitmap);
        x.i("MicroMsg.FTS.FTSBaseWebViewUI", "onPageStarted %s", new Object[]{str});
        this.tCF.showOptionMenu(false);
        if (!(FTSBaseWebViewUI.i(this.tCF) == null || FTSBaseWebViewUI.j(this.tCF))) {
            FTSBaseWebViewUI.bTA();
            FTSBaseWebViewUI.i(this.tCF).zet.yig.clearFocus();
            this.tCF.aWs();
        }
        g.bk(FTSBaseWebViewUI.g(this.tCF), 1);
        g.bl(FTSBaseWebViewUI.g(this.tCF), 1);
    }

    public final m a(WebView webView, l lVar, Bundle bundle) {
        if (!(lVar == null || lVar.getUrl() == null || !lVar.getUrl().toString().startsWith("weixin://fts"))) {
            m Pv = Pv(lVar.getUrl().toString());
            if (Pv != null) {
                return Pv;
            }
        }
        return super.a(webView, lVar);
    }

    public final m a(WebView webView, l lVar) {
        if (!(lVar == null || lVar.getUrl() == null || !lVar.getUrl().toString().startsWith("weixin://fts"))) {
            m Pv = Pv(lVar.getUrl().toString());
            if (Pv != null) {
                return Pv;
            }
        }
        return super.a(webView, lVar);
    }

    public final m c(WebView webView, String str) {
        if (str.startsWith("weixin://fts")) {
            m Pv = Pv(str);
            if (Pv != null) {
                return Pv;
            }
        }
        return super.c(webView, str);
    }

    private static m Pv(String str) {
        InputStream openRead;
        x.i("MicroMsg.FTS.FTSBaseWebViewUI", "url=%s | thread=%d", new Object[]{str, Long.valueOf(Thread.currentThread().getId())});
        try {
            openRead = FileOp.openRead(Uri.parse(str).getQueryParameter("path"));
        } catch (Exception e) {
            openRead = null;
        }
        if (openRead != null) {
            return new m("image/*", "utf8", openRead);
        }
        return null;
    }

    public final void a(WebView webView, int i, String str, String str2) {
        super.a(webView, i, str, str2);
        if (str2 != null && str2.equals(this.tCF.fIG)) {
            g.bk(FTSBaseWebViewUI.g(this.tCF), 16);
        }
    }
}
