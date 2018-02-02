package com.tencent.mm.plugin.scanner.history.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ScannerHistoryUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ScannerHistoryUI pSn;

    ScannerHistoryUI$1(ScannerHistoryUI scannerHistoryUI) {
        this.pSn = scannerHistoryUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.pSn.finish();
        return true;
    }
}
