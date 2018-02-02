package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckedTextView;

class WalletCardImportUI$8 implements OnItemClickListener {
    final /* synthetic */ WalletCardImportUI sSH;

    WalletCardImportUI$8(WalletCardImportUI walletCardImportUI) {
        this.sSH = walletCardImportUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.sSH.dismissDialog(1);
        int intValue = ((Integer) WalletCardImportUI.c(this.sSH).bLc().get(i)).intValue();
        if (WalletCardImportUI.f(this.sSH) != intValue) {
            WalletCardImportUI.a(this.sSH, intValue);
            WalletCardImportUI.g(this.sSH).setText(((CheckedTextView) view).getText().toString());
            WalletCardImportUI.c(WalletCardImportUI.h(this.sSH), WalletCardImportUI.f(this.sSH));
            WalletCardImportUI.h(this.sSH).bmK();
            WalletCardImportUI.i(this.sSH);
        }
    }
}
