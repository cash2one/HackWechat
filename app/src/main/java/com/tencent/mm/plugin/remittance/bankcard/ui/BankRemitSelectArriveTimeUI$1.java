package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BankRemitSelectArriveTimeUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ BankRemitSelectArriveTimeUI pJF;

    BankRemitSelectArriveTimeUI$1(BankRemitSelectArriveTimeUI bankRemitSelectArriveTimeUI) {
        this.pJF = bankRemitSelectArriveTimeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.pJF.finish();
        return false;
    }
}
