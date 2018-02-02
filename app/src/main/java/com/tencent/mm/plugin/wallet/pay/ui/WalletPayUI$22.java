package com.tencent.mm.plugin.wallet.pay.ui;

import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mm.ui.base.i;

class WalletPayUI$22 implements OnCheckedChangeListener {
    final /* synthetic */ WalletPayUI sGh;
    final /* synthetic */ i sGk;

    WalletPayUI$22(WalletPayUI walletPayUI, i iVar) {
        this.sGh = walletPayUI;
        this.sGk = iVar;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        Button button = this.sGk.getButton(-2);
        if (z) {
            button.setEnabled(false);
        } else {
            button.setEnabled(true);
        }
    }
}
