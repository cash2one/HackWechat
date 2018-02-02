package com.tencent.mm.ui.base;

import android.view.MenuItem;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.p.d;

class h$9 implements d {
    final /* synthetic */ c xYQ;

    h$9(c cVar) {
        this.xYQ = cVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        if (this.xYQ != null) {
            this.xYQ.jl(menuItem.getItemId());
        }
    }
}
