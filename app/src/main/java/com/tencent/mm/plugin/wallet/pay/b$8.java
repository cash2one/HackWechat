package com.tencent.mm.plugin.wallet.pay;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class b$8 implements OnClickListener {
    final /* synthetic */ b sEl;
    final /* synthetic */ WalletBaseUI sEm;

    b$8(b bVar, WalletBaseUI walletBaseUI) {
        this.sEl = bVar;
        this.sEm = walletBaseUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Bankcard bankcard = (Bankcard) b.C(this.sEl).getParcelable("key_bankcard");
        PayInfo payInfo = (PayInfo) b.D(this.sEl).getParcelable("key_pay_info");
        if (!(bankcard == null || payInfo == null)) {
            bankcard.sLe = payInfo.fuH;
        }
        b.E(this.sEl).putInt("key_err_code", -1004);
        this.sEl.a(this.sEm, 0, b.F(this.sEl));
        if (this.sEm.aYf()) {
            this.sEm.finish();
        }
    }
}
