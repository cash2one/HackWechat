package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wxcredit.b;
import com.tencent.mm.wallet_core.a;

class WalletWXCreditOpenNotifyUI$2 implements OnClickListener {
    final /* synthetic */ WalletWXCreditOpenNotifyUI uaj;

    WalletWXCreditOpenNotifyUI$2(WalletWXCreditOpenNotifyUI walletWXCreditOpenNotifyUI) {
        this.uaj = walletWXCreditOpenNotifyUI;
    }

    public final void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_bankcard", this.uaj.vf.getParcelable("key_bankcard"));
        a.a(this.uaj, b.class, bundle);
    }
}
