package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class IPCallAcitivityUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ IPCallAcitivityUI nHI;

    IPCallAcitivityUI$3(IPCallAcitivityUI iPCallAcitivityUI) {
        this.nHI = iPCallAcitivityUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.nHI.finish();
        return true;
    }
}
