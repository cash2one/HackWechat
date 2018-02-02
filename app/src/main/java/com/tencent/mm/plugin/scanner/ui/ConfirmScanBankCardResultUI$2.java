package com.tencent.mm.plugin.scanner.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ConfirmScanBankCardResultUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ ConfirmScanBankCardResultUI pVe;

    ConfirmScanBankCardResultUI$2(ConfirmScanBankCardResultUI confirmScanBankCardResultUI) {
        this.pVe = confirmScanBankCardResultUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.pVe.finish();
        return true;
    }
}
