package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.balance.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;

class WalletBalanceManagerUI$6 implements OnClickListener {
    final /* synthetic */ WalletBalanceManagerUI szV;

    WalletBalanceManagerUI$6(WalletBalanceManagerUI walletBalanceManagerUI) {
        this.szV = walletBalanceManagerUI;
    }

    public final void onClick(View view) {
        p.bJN();
        ArrayList bLZ = p.bJO().bLZ();
        if (bLZ == null || bLZ.size() == 0) {
            x.i("MicroMsg.WalletBalanceManagerUI", "mBankcardList is empty, do bind card to fetch");
            WalletBalanceManagerUI.b(this.szV);
            return;
        }
        x.i("MicroMsg.WalletBalanceManagerUI", "mBankcardList is valid, to do fetch");
        a.a(this.szV, b.class, null, null);
        e.HF(15);
    }
}
