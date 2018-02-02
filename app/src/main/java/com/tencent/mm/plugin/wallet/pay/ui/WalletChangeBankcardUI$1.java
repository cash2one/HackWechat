package com.tencent.mm.plugin.wallet.pay.ui;

import com.tencent.mm.g.a.su;
import com.tencent.mm.g.a.tf;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class WalletChangeBankcardUI$1 extends c<tf> {
    final /* synthetic */ WalletChangeBankcardUI sEU;

    WalletChangeBankcardUI$1(WalletChangeBankcardUI walletChangeBankcardUI) {
        this.sEU = walletChangeBankcardUI;
        this.xen = tf.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        tf tfVar = (tf) bVar;
        x.i("MicroMsg.WalletChangeBankcardUI", "realnameNotifyListener %s", new Object[]{Integer.valueOf(tfVar.fLI.result)});
        b suVar = new su();
        if (tfVar.fLI.result == -1) {
            suVar.fKE.scene = 17;
        } else if (tfVar.fLI.result == 0) {
            suVar.fKE.scene = 18;
        } else {
            suVar.fKE.scene = 0;
        }
        suVar.fKF.fKz = new 1(this, tfVar);
        a.xef.m(suVar);
        return false;
    }
}
