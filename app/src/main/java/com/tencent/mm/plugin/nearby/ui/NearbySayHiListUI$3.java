package com.tencent.mm.plugin.nearby.ui;

import android.view.MenuItem;
import com.tencent.mm.bf.l;
import com.tencent.mm.ui.base.p.d;

class NearbySayHiListUI$3 implements d {
    final /* synthetic */ NearbySayHiListUI oPo;

    NearbySayHiListUI$3(NearbySayHiListUI nearbySayHiListUI) {
        this.oPo = nearbySayHiListUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        l.Ty().mY(String.valueOf(NearbySayHiListUI.h(this.oPo)));
        NearbySayHiListUI.b(this.oPo).a(null, null);
        if (NearbySayHiListUI.c(this.oPo) > 0) {
            NearbySayHiListUI.i(this.oPo);
        }
        NearbySayHiListUI.j(this.oPo);
    }
}
