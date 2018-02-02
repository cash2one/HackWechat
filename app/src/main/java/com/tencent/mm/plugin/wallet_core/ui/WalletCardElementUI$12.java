package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;

class WalletCardElementUI$12 implements OnClickListener {
    final /* synthetic */ WalletCardElementUI sSA;

    WalletCardElementUI$12(WalletCardElementUI walletCardElementUI) {
        this.sSA = walletCardElementUI;
    }

    public final void onClick(View view) {
        Intent putExtra = new Intent("com.tencent.mm.action.GET_ADRESS").putExtra("GetAddress", true).putExtra("ShowSelectedLocation", false);
        if (Bankcard.zh(WalletCardElementUI.d(this.sSA).sIJ)) {
            putExtra.putExtra("IsAutoPosition", false);
        } else {
            putExtra.putExtra("IsRealNameVerifyScene", true);
            putExtra.putExtra("IsNeedShowSearchBar", true);
        }
        this.sSA.startActivityForResult(putExtra, 2);
    }
}
