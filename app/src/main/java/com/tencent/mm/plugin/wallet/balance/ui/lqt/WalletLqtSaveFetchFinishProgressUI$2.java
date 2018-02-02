package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;

class WalletLqtSaveFetchFinishProgressUI$2 implements OnClickListener {
    final /* synthetic */ WalletLqtSaveFetchFinishProgressUI sAS;

    WalletLqtSaveFetchFinishProgressUI$2(WalletLqtSaveFetchFinishProgressUI walletLqtSaveFetchFinishProgressUI) {
        this.sAS = walletLqtSaveFetchFinishProgressUI;
    }

    public final void onClick(View view) {
        this.sAS.finish();
    }
}
