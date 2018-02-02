package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mm.wallet_core.ui.e;

class WalletLqtDetailUI$6 implements OnClickListener {
    final /* synthetic */ WalletLqtDetailUI sAM;
    final /* synthetic */ LinearLayout sAQ;

    WalletLqtDetailUI$6(WalletLqtDetailUI walletLqtDetailUI, LinearLayout linearLayout) {
        this.sAM = walletLqtDetailUI;
        this.sAQ = linearLayout;
    }

    public final void onClick(View view) {
        e.l(this.sAM, (String) this.sAQ.getTag(), false);
    }
}
