package com.tencent.mm.plugin.wallet.pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckedTextView;

class WalletPayUI$28 implements OnClickListener {
    final /* synthetic */ WalletPayUI sGh;
    final /* synthetic */ CheckedTextView sGn;
    final /* synthetic */ CheckedTextView sGo;

    WalletPayUI$28(WalletPayUI walletPayUI, CheckedTextView checkedTextView, CheckedTextView checkedTextView2) {
        this.sGh = walletPayUI;
        this.sGn = checkedTextView;
        this.sGo = checkedTextView2;
    }

    public final void onClick(View view) {
        this.sGn.setChecked(true);
        this.sGo.setChecked(false);
        WalletPayUI.a(this.sGh, false);
        WalletPayUI.c(this.sGh);
    }
}
