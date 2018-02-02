package com.tencent.mm.plugin.nearby.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class NearbySayHiListUI$12 implements OnMenuItemClickListener {
    final /* synthetic */ NearbySayHiListUI oPo;

    NearbySayHiListUI$12(NearbySayHiListUI nearbySayHiListUI) {
        this.oPo = nearbySayHiListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.oPo.aWs();
        this.oPo.setResult(0);
        this.oPo.finish();
        return true;
    }
}
