package com.tencent.mm.plugin.wallet.pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;

class WalletPayUI$19 implements OnClickListener {
    final /* synthetic */ WalletPayUI sGh;
    final /* synthetic */ CheckBox sGj;

    WalletPayUI$19(WalletPayUI walletPayUI, CheckBox checkBox) {
        this.sGh = walletPayUI;
        this.sGj = checkBox;
    }

    public final void onClick(View view) {
        this.sGj.setChecked(!this.sGj.isChecked());
    }
}
