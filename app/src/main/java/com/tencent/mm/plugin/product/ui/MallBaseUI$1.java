package com.tencent.mm.plugin.product.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class MallBaseUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ MallBaseUI pfg;

    MallBaseUI$1(MallBaseUI mallBaseUI) {
        this.pfg = mallBaseUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.pfg.finish();
        return true;
    }
}
