package com.tencent.mm.plugin.order.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class MallOrderDetailInfoUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ MallOrderDetailInfoUI pcg;

    MallOrderDetailInfoUI$4(MallOrderDetailInfoUI mallOrderDetailInfoUI) {
        this.pcg = mallOrderDetailInfoUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        MallOrderDetailInfoUI.d(this.pcg);
        return true;
    }
}
