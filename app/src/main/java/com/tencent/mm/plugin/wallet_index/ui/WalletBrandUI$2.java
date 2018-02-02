package com.tencent.mm.plugin.wallet_index.ui;

import com.tencent.mm.g.a.sz;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class WalletBrandUI$2 extends c<sz> {
    final /* synthetic */ WalletBrandUI tbb;

    WalletBrandUI$2(WalletBrandUI walletBrandUI) {
        this.tbb = walletBrandUI;
        this.xen = sz.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        sz szVar = (sz) bVar;
        x.i("MicroMsg.WalletBrandUI", "onPayEnd payResult : " + szVar.fLs.result);
        this.tbb.setResult(szVar.fLs.result, szVar.fLs.intent);
        this.tbb.finish();
        return true;
    }
}
