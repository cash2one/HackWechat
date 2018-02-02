package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;

class WalletCardElementUI$6 implements OnClickListener {
    final /* synthetic */ WalletCardElementUI sSA;

    WalletCardElementUI$6(WalletCardElementUI walletCardElementUI) {
        this.sSA = walletCardElementUI;
    }

    public final void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("key_support_bankcard", this.sSA.vf.getInt("key_support_bankcard", 3));
        bundle.putInt("key_bind_scene", this.sSA.vf.getInt("key_bind_scene", -1));
        if (!bh.ov(WalletCardElementUI.c(this.sSA).getText())) {
            bundle.putString("key_bank_type", WalletCardElementUI.d(this.sSA).oZz);
            bundle.putInt("key_bankcard_type", WalletCardElementUI.d(this.sSA).sMz);
        }
        c ag = a.ag(this.sSA);
        if (ag != null) {
            ag.a(this.sSA, WalletCardSelectUI.class, bundle, 1);
        }
    }
}
