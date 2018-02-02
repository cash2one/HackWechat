package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.WalletSelectBankcardUI.2;

class WalletSelectBankcardUI$2$2 implements OnClickListener {
    final /* synthetic */ Bankcard sWm;
    final /* synthetic */ 2 sWn;

    WalletSelectBankcardUI$2$2(2 2, Bankcard bankcard) {
        this.sWn = 2;
        this.sWm = bankcard;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.sWn.sWl.vf.putBoolean("key_balance_change_phone_need_confirm_phone", true);
        WalletSelectBankcardUI.a(this.sWn.sWl, this.sWm);
    }
}
