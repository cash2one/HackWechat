package com.tencent.mm.plugin.remittance.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class RemittanceBusiUI$12 implements OnMenuItemClickListener {
    final /* synthetic */ RemittanceBusiUI pOd;

    RemittanceBusiUI$12(RemittanceBusiUI remittanceBusiUI) {
        this.pOd = remittanceBusiUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (RemittanceBusiUI.f(this.pOd)) {
            this.pOd.aWs();
            this.pOd.showDialog(1000);
        } else {
            this.pOd.finish();
        }
        return true;
    }
}
