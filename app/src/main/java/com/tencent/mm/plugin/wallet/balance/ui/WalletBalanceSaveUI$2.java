package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.ui.h;
import com.tencent.mm.plugin.wxpay.a.i;

class WalletBalanceSaveUI$2 implements OnClickListener {
    final /* synthetic */ WalletBalanceSaveUI sAi;

    WalletBalanceSaveUI$2(WalletBalanceSaveUI walletBalanceSaveUI) {
        this.sAi = walletBalanceSaveUI;
    }

    public final void onClick(View view) {
        Context context = this.sAi.mController.xIM;
        h.a(context, WalletBalanceSaveUI.a(this.sAi), WalletBalanceSaveUI.b(this.sAi), context.getString(i.uPC), this.sAi.szl, new 1(this));
    }
}
