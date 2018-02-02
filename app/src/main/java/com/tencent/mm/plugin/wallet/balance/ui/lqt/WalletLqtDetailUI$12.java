package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.vending.g.g;

class WalletLqtDetailUI$12 implements OnClickListener {
    final /* synthetic */ WalletLqtDetailUI sAM;

    WalletLqtDetailUI$12(WalletLqtDetailUI walletLqtDetailUI) {
        this.sAM = walletLqtDetailUI;
    }

    public final void onClick(View view) {
        g.cp(Integer.valueOf(WalletLqtDetailUI.c(this.sAM).vXn)).b(WalletLqtDetailUI.f(this.sAM).syA);
        Intent intent = new Intent(this.sAM, WalletLqtSaveFetchUI.class);
        intent.putExtra("lqt_save_fetch_mode", 2);
        intent.putExtra("lqt_balance", WalletLqtDetailUI.c(this.sAM).bME);
        intent.putExtra("lqt_max_redeem_amount", WalletLqtDetailUI.c(this.sAM).wGN);
        intent.putExtra("lqt_redeem_invalid_amount_hint", WalletLqtDetailUI.c(this.sAM).wGO);
        intent.putExtra("lqt_account_type", WalletLqtDetailUI.c(this.sAM).vXn);
        this.sAM.startActivity(intent);
    }
}
