package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.wallet_core.a;

class WalletCardImportUI$2 implements OnClickListener {
    final /* synthetic */ WalletCardImportUI sSH;

    WalletCardImportUI$2(WalletCardImportUI walletCardImportUI) {
        this.sSH = walletCardImportUI;
    }

    public final void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("key_support_bankcard", this.sSH.vf.getInt("key_support_bankcard", 3));
        bundle.putString("key_bank_type", WalletCardImportUI.c(this.sSH).oZz);
        bundle.putInt("key_bankcard_type", WalletCardImportUI.c(this.sSH).sMz);
        a.ag(this.sSH).a(this.sSH, WalletCardSelectUI.class, bundle, 1);
    }
}
