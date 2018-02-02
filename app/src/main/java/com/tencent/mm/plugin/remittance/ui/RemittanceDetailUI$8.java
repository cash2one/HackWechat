package com.tencent.mm.plugin.remittance.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.wallet_core.ui.e;

class RemittanceDetailUI$8 implements OnMenuItemClickListener {
    final /* synthetic */ RemittanceDetailUI pOO;

    RemittanceDetailUI$8(RemittanceDetailUI remittanceDetailUI) {
        this.pOO = remittanceDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        e.l(this.pOO.mController.xIM, RemittanceDetailUI.d(this.pOO), false);
        return false;
    }
}
