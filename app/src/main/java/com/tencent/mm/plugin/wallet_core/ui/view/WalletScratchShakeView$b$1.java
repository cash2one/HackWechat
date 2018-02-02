package com.tencent.mm.plugin.wallet_core.ui.view;

import com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView.b;
import com.tencent.mm.pluginsdk.k.c$a;
import com.tencent.mm.sdk.platformtools.bh;

class WalletScratchShakeView$b$1 extends c$a {
    final /* synthetic */ b sXZ;

    WalletScratchShakeView$b$1(b bVar) {
        this.sXZ = bVar;
    }

    public final void beP() {
        long bA = bh.bA(b.a(this.sXZ));
        if (b.b(this.sXZ)) {
            if (bA < 80) {
                return;
            }
        } else if (bA < 1200) {
            return;
        }
        b.a(this.sXZ, bh.Wq());
        b.c(this.sXZ);
        b.d(this.sXZ);
    }

    public final void onRelease() {
    }
}
