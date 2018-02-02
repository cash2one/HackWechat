package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.webview.ui.tools.fts.LoadDataWebviewUI.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;

class LoadDataWebviewUI$a$1 implements Runnable {
    final /* synthetic */ WebView tDY;
    final /* synthetic */ Bitmap tDZ;
    final /* synthetic */ a tEa;
    final /* synthetic */ String val$url;

    LoadDataWebviewUI$a$1(a aVar, WebView webView, String str, Bitmap bitmap) {
        this.tEa = aVar;
        this.tDY = webView;
        this.val$url = str;
        this.tDZ = bitmap;
    }

    public final void run() {
        try {
            LoadDataWebviewUI.a(this.tEa.tDX).await();
        } catch (Throwable e) {
            x.printErrStackTrace("LoadDataWebviewUI", e, "", new Object[0]);
        }
        ag.y(new 1(this));
    }
}
