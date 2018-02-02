package com.tencent.mm.ui.base;

import android.view.MenuItem;

class h$5 implements p$d {
    final /* synthetic */ h$d xYP;

    h$5(h$d com_tencent_mm_ui_base_h_d) {
        this.xYP = com_tencent_mm_ui_base_h_d;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        if (this.xYP != null) {
            this.xYP.cn(i, menuItem.getItemId());
        }
    }
}
