package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class WalletRealNameVerifyUI$2 implements OnClickListener {
    final /* synthetic */ WalletRealNameVerifyUI sJO;

    WalletRealNameVerifyUI$2(WalletRealNameVerifyUI walletRealNameVerifyUI) {
        this.sJO = walletRealNameVerifyUI;
    }

    public final void onClick(View view) {
        this.sJO.startActivityForResult(new Intent("com.tencent.mm.action.GET_ADRESS").putExtra("GetAddress", true).putExtra("ShowSelectedLocation", false).putExtra("IsRealNameVerifyScene", true).putExtra("IsNeedShowSearchBar", true), 2);
    }
}
