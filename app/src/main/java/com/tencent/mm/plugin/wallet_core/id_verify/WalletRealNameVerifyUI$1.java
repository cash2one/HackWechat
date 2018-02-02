package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.ui.WalletSelectProfessionUI;

class WalletRealNameVerifyUI$1 implements OnClickListener {
    final /* synthetic */ WalletRealNameVerifyUI sJO;

    WalletRealNameVerifyUI$1(WalletRealNameVerifyUI walletRealNameVerifyUI) {
        this.sJO = walletRealNameVerifyUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.sJO.mController.xIM, WalletSelectProfessionUI.class);
        intent.putExtra("key_profession_list", WalletRealNameVerifyUI.a(this.sJO));
        this.sJO.startActivityForResult(intent, 1);
    }
}
