package com.tencent.mm.plugin.wxcredit.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.wallet_core.ui.e;

class WalletWXCreditOpenUI$2 implements OnClickListener {
    final /* synthetic */ WalletWXCreditOpenUI uam;

    WalletWXCreditOpenUI$2(WalletWXCreditOpenUI walletWXCreditOpenUI) {
        this.uam = walletWXCreditOpenUI;
    }

    public final void onClick(View view) {
        e.a(this.uam, WalletWXCreditOpenUI.b(this.uam).field_bankcardType, WalletWXCreditOpenUI.b(this.uam).field_bankName, true, false);
    }
}
