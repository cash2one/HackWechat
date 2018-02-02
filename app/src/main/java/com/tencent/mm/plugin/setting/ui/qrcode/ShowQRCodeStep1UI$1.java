package com.tencent.mm.plugin.setting.ui.qrcode;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ShowQRCodeStep1UI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ShowQRCodeStep1UI qgN;

    ShowQRCodeStep1UI$1(ShowQRCodeStep1UI showQRCodeStep1UI) {
        this.qgN = showQRCodeStep1UI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qgN.aWs();
        this.qgN.finish();
        return true;
    }
}
