package com.tencent.mm.plugin.wallet.pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.27.1;
import com.tencent.mm.sdk.platformtools.x;

class WalletPayUI$27$1$1 implements OnClickListener {
    final /* synthetic */ 1 sGm;

    WalletPayUI$27$1$1(1 1) {
        this.sGm = 1;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.WalletPayUI", "mDefaultBankcard null or needToPayWithBankcard after favor selection! payWithNewBankcard");
        this.sGm.sGl.sGh.b(false, 0, "");
    }
}
