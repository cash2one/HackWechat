package com.tencent.mm.plugin.remittance.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.wallet_core.ui.e;

class RemittanceBaseUI$16 implements OnMenuItemClickListener {
    final /* synthetic */ RemittanceBaseUI pMw;

    RemittanceBaseUI$16(RemittanceBaseUI remittanceBaseUI) {
        this.pMw = remittanceBaseUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        e.l(this.pMw.mController.xIM, this.pMw.pMl, false);
        return false;
    }
}
