package com.tencent.mm.plugin.wallet_ecard.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;

class WalletECardElementInputUI$1 implements OnClickListener {
    final /* synthetic */ WalletECardElementInputUI sZQ;

    WalletECardElementInputUI$1(WalletECardElementInputUI walletECardElementInputUI) {
        this.sZQ = walletECardElementInputUI;
    }

    public final void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("key_support_bankcard", this.sZQ.vf.getInt("key_support_bankcard", 3));
        bundle.putInt("key_bind_scene", this.sZQ.vf.getInt("key_bind_scene", -1));
        if (!bh.ov(WalletECardElementInputUI.a(this.sZQ).getText())) {
            bundle.putString("key_bank_type", WalletECardElementInputUI.b(this.sZQ).oZz);
            bundle.putInt("key_bankcard_type", WalletECardElementInputUI.b(this.sZQ).sMz);
        }
        c ag = a.ag(this.sZQ);
        if (ag != null) {
            ag.a(this.sZQ, WalletCardSelectUI.class, bundle, 1);
        }
    }
}
