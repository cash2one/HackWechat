package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.x;

class BankRemitDetailUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ BankRemitDetailUI pIP;

    BankRemitDetailUI$1(BankRemitDetailUI bankRemitDetailUI) {
        this.pIP = bankRemitDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        x.i("MicroMsg.BankRemitDetailUI", "back press");
        this.pIP.finish();
        return false;
    }
}
