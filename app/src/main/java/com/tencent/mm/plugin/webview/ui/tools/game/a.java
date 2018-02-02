package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi$a;
import com.tencent.mm.plugin.webview.ui.tools.widget.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;

public final class a {
    ViewGroup Fl;
    MMWebView juE;
    Context mContext;
    String mXZ;
    c mZw = new 1(this);
    GameWebViewUI tFg;
    private d tFh;
    d tFi;
    com.tencent.mm.plugin.webview.ui.tools.jsapi.d tFj;
    com.tencent.mm.plugin.webview.wepkg.a tFk;
    a tFl;
    f tFm;
    g tFn = new 3(this);

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ a tFo;
        final /* synthetic */ String val$url;

        AnonymousClass2(a aVar, String str) {
            this.tFo = aVar;
            this.val$url = str;
        }

        public final void run() {
            this.tFo.juE.setVisibility(8);
            this.tFo.tFl.Py(this.val$url);
        }
    }

    private class b extends com.tencent.xweb.x5.a.a.a.a.b {
        final /* synthetic */ a tFo;

        private b(a aVar) {
            this.tFo = aVar;
        }

        public final Object onMiscCallBack(String str, Bundle bundle) {
            Object onMiscCallBack = this.tFo.tFk.tLw.onMiscCallBack(str, bundle);
            return onMiscCallBack != null ? onMiscCallBack : super.onMiscCallBack(str, bundle);
        }
    }

    public a(GameWebViewUI gameWebViewUI, ViewGroup viewGroup) {
        this.mContext = gameWebViewUI;
        this.tFg = gameWebViewUI;
        this.Fl = viewGroup;
        WebView dS = MMWebViewWithJsApi$a.dS(this.mContext);
        dS.setBackgroundResource(17170445);
        dS.setBackgroundColor(0);
        dS.setVisibility(4);
        this.tFl = new a(this, dS);
        dS.setWebViewClient(this.tFl);
        if (dS.isX5Kernel) {
            dS.setWebViewClientExtension(new b());
        }
        dS.getSettings().setJavaScriptEnabled(true);
        dS.getSettings().cIw();
        dS.getSettings().setBuiltInZoomControls(false);
        dS.getSettings().setUseWideViewPort(true);
        dS.getSettings().setLoadWithOverviewMode(true);
        dS.getSettings().cIr();
        dS.getSettings().cIq();
        dS.getSettings().setGeolocationEnabled(true);
        dS.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        dS.getSettings().cIy();
        dS.getSettings().cIu();
        dS.getSettings().setAppCachePath(this.mContext.getDir("webviewcache", 0).getAbsolutePath());
        dS.getSettings().cIt();
        dS.getSettings().cIv();
        dS.getSettings().setDatabasePath(e.gZJ + "databases/");
        com.tencent.xweb.b.cIj().cIk();
        com.tencent.xweb.b.cIj().b(dS);
        this.juE = dS;
        this.tFh = new d(gameWebViewUI.getIntent());
        this.tFk = new com.tencent.mm.plugin.webview.wepkg.a(gameWebViewUI, this.juE, this.juE.hashCode());
    }

    public final void bUd() {
        if (this.tFk == null || !this.tFk.PO(this.mXZ)) {
            x.i("MicroMsg.GameFloatWebView", "no use wepkg, dont reload");
            return;
        }
        x.i("MicroMsg.GameFloatWebView", "float page, reload url:%s from net", new Object[]{this.mXZ});
        this.tFk.bUX();
        if (this.juE != null && this.juE.getParent() != null && this.tFl != null && !bh.ov(this.mXZ)) {
            this.juE.stopLoading();
            this.tFl.Py(this.mXZ);
        }
    }

    final int cB(String str, int i) {
        if (i == 0) {
            if (str == null || str.length() <= 0) {
                i = 0;
            } else if (this.tFi == null) {
                i = 1;
            } else {
                try {
                    i = this.tFi.hn(str) ? 8 : this.tFi.gF(str) ? 7 : 1;
                } catch (Exception e) {
                    x.e("MicroMsg.GameFloatWebView", "getScene fail, ex = " + e.getMessage());
                    i = 1;
                }
            }
        }
        x.i("MicroMsg.GameFloatWebView", "KGetA8KeyScene = %s", new Object[]{Integer.valueOf(i)});
        return i;
    }

    public final void onDestroy() {
        c.a(this.mZw.tFt.tFu);
    }
}
