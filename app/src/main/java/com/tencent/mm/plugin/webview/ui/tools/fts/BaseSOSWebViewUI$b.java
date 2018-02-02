package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.webview.ui.tools.fts.LoadDataWebviewUI.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;
import com.tencent.xweb.l;
import com.tencent.xweb.m;
import java.io.InputStream;

class BaseSOSWebViewUI$b extends a {
    final /* synthetic */ BaseSOSWebViewUI tCm;

    private BaseSOSWebViewUI$b(BaseSOSWebViewUI baseSOSWebViewUI) {
        this.tCm = baseSOSWebViewUI;
        super(baseSOSWebViewUI);
    }

    public final void a(WebView webView, String str) {
        super.a(webView, str);
        x.i("MicroMsg.FTS.BaseSOSWebViewUI", "scene %d, onPageFinished %s", new Object[]{Integer.valueOf(this.tCm.scene), str});
        this.tCm.showOptionMenu(false);
        if (!(this.tCm.tCg == null || BaseSOSWebViewUI.m(this.tCm))) {
            BaseSOSWebViewUI.bTz();
            this.tCm.tCg.yig.clearFocus();
            this.tCm.aWs();
        }
        BaseSOSWebViewUI.n(this.tCm);
        this.tCm.bTv();
    }

    public final void b(WebView webView, String str, Bitmap bitmap) {
        super.b(webView, str, bitmap);
        x.i("MicroMsg.FTS.BaseSOSWebViewUI", "onPageStarted %s", new Object[]{str});
        this.tCm.showOptionMenu(false);
        if (this.tCm.tCg != null && !BaseSOSWebViewUI.m(this.tCm)) {
            BaseSOSWebViewUI.bTA();
            this.tCm.tCg.yig.clearFocus();
            this.tCm.aWs();
        }
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
        x.i("MicroMsg.FTS.BaseSOSWebViewUI", "url=%s | thread=%d", new Object[]{str, Long.valueOf(Thread.currentThread().getId())});
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
}
