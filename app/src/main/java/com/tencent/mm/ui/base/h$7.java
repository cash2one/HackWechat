package com.tencent.mm.ui.base;

import android.view.MenuItem;
import com.tencent.mm.ui.base.h.c;

class h$7 implements p$d {
    final /* synthetic */ c xYQ;

    h$7(c cVar) {
        this.xYQ = cVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        if (this.xYQ != null) {
            this.xYQ.jl(menuItem.getItemId());
        }
    }
}
