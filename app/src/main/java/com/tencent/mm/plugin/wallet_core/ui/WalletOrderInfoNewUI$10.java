package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.g.a.am;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class WalletOrderInfoNewUI$10 extends c<am> {
    final /* synthetic */ WalletOrderInfoNewUI sUp;

    WalletOrderInfoNewUI$10(WalletOrderInfoNewUI walletOrderInfoNewUI) {
        this.sUp = walletOrderInfoNewUI;
        this.xen = am.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        am amVar = (am) bVar;
        String str = amVar.foz.foB;
        boolean z = amVar.foz.foC;
        x.i("MicroMsg.WalletOrderInfoNewUI", "ChangePayActivityViewEvent callback, mActivityBtnTitle: %s, isButtonEnable: %s, isButtonHidden: %s, isActivityViewHidden: %s", new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(amVar.foz.foD), Boolean.valueOf(amVar.foz.foE)});
        if (amVar.foz.foE && !bh.ov(WalletOrderInfoNewUI.b(this.sUp))) {
            WalletOrderInfoNewUI.c(this.sUp).setVisibility(8);
        }
        if (!bh.ov(WalletOrderInfoNewUI.b(this.sUp))) {
            WalletOrderInfoNewUI.d(this.sUp).setClickable(z);
            WalletOrderInfoNewUI.d(this.sUp).setEnabled(z);
            WalletOrderInfoNewUI.d(this.sUp).setOnClickListener(null);
            if (r2) {
                WalletOrderInfoNewUI.d(this.sUp).setVisibility(8);
            }
        }
        amVar.foA.fnI = true;
        return false;
    }
}
