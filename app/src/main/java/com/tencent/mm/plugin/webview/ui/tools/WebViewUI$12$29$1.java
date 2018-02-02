package com.tencent.mm.plugin.webview.ui.tools;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.12.29;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$12$29$1 implements OnCreateContextMenuListener {
    final /* synthetic */ 29 tAR;

    WebViewUI$12$29$1(29 29) {
        this.tAR = 29;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        if (this.tAR.tAx.tAv.juX != null) {
            x.d("MicroMsg.WebViewUI", "show webkit menu");
            WebViewUI.a(this.tAR.tAx.tAv, contextMenu, this.tAR.tAx.tAv.juX);
            this.tAR.tAx.tAv.juX = null;
        } else if (this.tAR.tAx.tAv.juY != null) {
            x.d("MicroMsg.WebViewUI", "show IX5 menu");
            WebViewUI.b(this.tAR.tAx.tAv, contextMenu, this.tAR.tAx.tAv.juY);
            this.tAR.tAx.tAv.juY = null;
        }
    }
}
