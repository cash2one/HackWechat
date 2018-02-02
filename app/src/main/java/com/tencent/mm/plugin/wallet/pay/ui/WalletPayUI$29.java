package com.tencent.mm.plugin.wallet.pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckedTextView;

class WalletPayUI$29 implements OnClickListener {
    final /* synthetic */ WalletPayUI sGh;
    final /* synthetic */ CheckedTextView sGn;
    final /* synthetic */ CheckedTextView sGo;

    WalletPayUI$29(WalletPayUI walletPayUI, CheckedTextView checkedTextView, CheckedTextView checkedTextView2) {
        this.sGh = walletPayUI;
        this.sGn = checkedTextView;
        this.sGo = checkedTextView2;
    }

    public final void onClick(View view) {
        this.sGn.setChecked(false);
        this.sGo.setChecked(true);
        WalletPayUI.a(this.sGh, true);
        WalletPayUI.c(this.sGh);
    }
}
