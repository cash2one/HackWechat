package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SetTextSizeUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SetTextSizeUI qhN;

    SetTextSizeUI$1(SetTextSizeUI setTextSizeUI) {
        this.qhN = setTextSizeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qhN.aWs();
        this.qhN.finish();
        return true;
    }
}
