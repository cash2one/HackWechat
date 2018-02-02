package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckedTextView;

class WalletCardElementUI$2 implements OnItemClickListener {
    final /* synthetic */ WalletCardElementUI sSA;

    WalletCardElementUI$2(WalletCardElementUI walletCardElementUI) {
        this.sSA = walletCardElementUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.sSA.dismissDialog(1);
        int intValue = ((Integer) WalletCardElementUI.d(this.sSA).bLc().get(i)).intValue();
        if (WalletCardElementUI.g(this.sSA) != intValue) {
            WalletCardElementUI.a(this.sSA, intValue);
            WalletCardElementUI.h(this.sSA).setText(((CheckedTextView) view).getText().toString());
            WalletCardElementUI.b(WalletCardElementUI.i(this.sSA), WalletCardElementUI.g(this.sSA));
            WalletCardElementUI.i(this.sSA).bmK();
            WalletCardElementUI.j(this.sSA);
            WalletCardElementUI.b(this.sSA, WalletCardElementUI.g(this.sSA));
        }
    }
}
