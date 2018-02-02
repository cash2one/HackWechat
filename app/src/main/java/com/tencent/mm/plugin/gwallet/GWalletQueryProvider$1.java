package com.tencent.mm.plugin.gwallet;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.gwallet.a.b.a;
import com.tencent.mm.plugin.gwallet.a.c;
import com.tencent.mm.sdk.platformtools.x;

class GWalletQueryProvider$1 implements a {
    final /* synthetic */ GWalletQueryProvider nzI;

    GWalletQueryProvider$1(GWalletQueryProvider gWalletQueryProvider) {
        this.nzI = gWalletQueryProvider;
    }

    public final void a(c cVar) {
        x.d("MicroMsg.GWalletQueryProvider", "Setup finished.");
        if (cVar.isSuccess()) {
            g.Dm().a(new 1(this));
            return;
        }
        x.e("MicroMsg.GWalletQueryProvider", "Problem setting up in-app billing: " + cVar);
        GWalletQueryProvider.a(this.nzI);
        if (GWalletQueryProvider.b(this.nzI) != null) {
            GWalletQueryProvider.b(this.nzI).dispose();
        }
        GWalletQueryProvider.c(this.nzI);
    }
}
