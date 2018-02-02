package com.tencent.mm.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class MultiStageCitySelectUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ MultiStageCitySelectUI zlZ;

    MultiStageCitySelectUI$5(MultiStageCitySelectUI multiStageCitySelectUI) {
        this.zlZ = multiStageCitySelectUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        MultiStageCitySelectUI.l(this.zlZ);
        this.zlZ.finish();
        return true;
    }
}
