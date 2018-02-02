package com.tencent.mm.plugin.wallet.pay;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class b$5 implements OnClickListener {
    final /* synthetic */ int fmb;
    final /* synthetic */ b sEl;
    final /* synthetic */ WalletBaseUI sEm;

    b$5(b bVar, int i, WalletBaseUI walletBaseUI) {
        this.sEl = bVar;
        this.fmb = i;
        this.sEm = walletBaseUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b.w(this.sEl).putInt("key_pay_flag", 3);
        b.x(this.sEl).putInt("key_err_code", this.fmb);
        this.sEl.a(this.sEm, 0, b.y(this.sEl));
        if (this.sEm.aYf()) {
            this.sEm.finish();
        }
    }
}
