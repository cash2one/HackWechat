package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SelfQRCodeUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ SelfQRCodeUI qhD;

    SelfQRCodeUI$2(SelfQRCodeUI selfQRCodeUI) {
        this.qhD = selfQRCodeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        SelfQRCodeUI.b(this.qhD);
        return true;
    }
}
