package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SelfQRCodeUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ SelfQRCodeUI qhD;

    SelfQRCodeUI$3(SelfQRCodeUI selfQRCodeUI) {
        this.qhD = selfQRCodeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qhD.aWs();
        this.qhD.finish();
        return true;
    }
}
