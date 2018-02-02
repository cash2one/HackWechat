package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.plugin.appbrand.jsapi.n.e.1.1;
import com.tencent.mm.sdk.platformtools.x;

class e$1$1$1 implements OnCreateContextMenuListener {
    final /* synthetic */ 1 jvg;

    e$1$1$1(1 1) {
        this.jvg = 1;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        if (this.jvg.jvf.jvd.juX != null) {
            x.d("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "show webkit menu");
            e.a(this.jvg.jvf.jvd, contextMenu, this.jvg.jvf.jvd.juX);
            this.jvg.jvf.jvd.juX = null;
        } else if (this.jvg.jvf.jvd.juY != null) {
            x.d("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "show IX5 menu");
            e.b(this.jvg.jvf.jvd, contextMenu, this.jvg.jvf.jvd.juY);
            this.jvg.jvf.jvd.juY = null;
        }
    }
}
