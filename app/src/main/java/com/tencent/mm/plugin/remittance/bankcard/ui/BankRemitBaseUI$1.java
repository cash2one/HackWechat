package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BankRemitBaseUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ BankRemitBaseUI pIy;

    BankRemitBaseUI$1(BankRemitBaseUI bankRemitBaseUI) {
        this.pIy = bankRemitBaseUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (BankRemitBaseUI.a(this.pIy)) {
            this.pIy.aWs();
            this.pIy.showDialog(1000);
        } else {
            this.pIy.finish();
        }
        return true;
    }
}
