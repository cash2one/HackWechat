package com.tencent.mm.plugin.wxcredit.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class WalletWXCreditOpenUI$1 implements OnCheckedChangeListener {
    final /* synthetic */ WalletWXCreditOpenUI uam;

    WalletWXCreditOpenUI$1(WalletWXCreditOpenUI walletWXCreditOpenUI) {
        this.uam = walletWXCreditOpenUI;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        WalletWXCreditOpenUI.a(this.uam).setEnabled(z);
    }
}
