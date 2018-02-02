package com.tencent.mm.plugin.shake.ui;

import android.view.MenuItem;
import com.tencent.mm.bf.l;
import com.tencent.mm.ui.base.p.d;

class ShakeSayHiListUI$2 implements d {
    final /* synthetic */ ShakeSayHiListUI qsr;

    ShakeSayHiListUI$2(ShakeSayHiListUI shakeSayHiListUI) {
        this.qsr = shakeSayHiListUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        l.Tz().mY(String.valueOf(ShakeSayHiListUI.g(this.qsr)));
        ShakeSayHiListUI.b(this.qsr).a(null, null);
    }
}
