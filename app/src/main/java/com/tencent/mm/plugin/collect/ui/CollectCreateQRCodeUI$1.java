package com.tencent.mm.plugin.collect.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CollectCreateQRCodeUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ CollectCreateQRCodeUI lma;

    CollectCreateQRCodeUI$1(CollectCreateQRCodeUI collectCreateQRCodeUI) {
        this.lma = collectCreateQRCodeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.lma.setResult(0);
        this.lma.finish();
        return true;
    }
}
