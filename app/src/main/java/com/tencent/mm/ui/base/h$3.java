package com.tencent.mm.ui.base;

import android.view.MenuItem;
import com.tencent.mm.ui.base.p.d;

class h$3 implements d {
    final /* synthetic */ h.d xYP;

    h$3(h.d dVar) {
        this.xYP = dVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        if (this.xYP != null) {
            this.xYP.cn(i, menuItem.getItemId());
        }
    }
}
