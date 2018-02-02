package com.tencent.mm.plugin.gwallet;

import com.tencent.mm.plugin.gwallet.GWalletQueryProvider.1;
import com.tencent.mm.sdk.platformtools.ag.a;

class GWalletQueryProvider$1$1 implements a {
    final /* synthetic */ 1 nzJ;

    GWalletQueryProvider$1$1(1 1) {
        this.nzJ = 1;
    }

    public final boolean JB() {
        GWalletQueryProvider.d(this.nzJ.nzI);
        return true;
    }

    public final boolean JC() {
        if (this.nzJ.nzI.nzC != null) {
            this.nzJ.nzI.nzC.dispose();
        }
        this.nzJ.nzI.nzC = null;
        return true;
    }

    public final String toString() {
        return super.toString() + "|onIabSetupFinished";
    }
}
