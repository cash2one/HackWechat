package com.tencent.mm.plugin.remittance.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class RemittanceBaseUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ RemittanceBaseUI pMw;

    RemittanceBaseUI$1(RemittanceBaseUI remittanceBaseUI) {
        this.pMw = remittanceBaseUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (this.pMw.irz == 1 || this.pMw.irz == 6) {
            this.pMw.bnI();
            this.pMw.finish();
        } else if (this.pMw.irz == 2 || this.pMw.irz == 5) {
            this.pMw.finish();
        } else {
            this.pMw.bnR();
        }
        this.pMw.bnJ();
        return true;
    }
}
