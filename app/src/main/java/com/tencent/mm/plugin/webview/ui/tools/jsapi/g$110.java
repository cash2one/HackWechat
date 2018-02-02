package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.view.MenuItem;
import com.tencent.mm.ui.base.p.d;

class g$110 implements d {
    final /* synthetic */ i tIg;
    final /* synthetic */ g tIj;

    g$110(g gVar, i iVar) {
        this.tIj = gVar;
        this.tIg = iVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
                g.dN(this.tIj, this.tIg);
                return;
            case 2:
                g.dO(this.tIj, this.tIg);
                return;
            default:
                return;
        }
    }
}
