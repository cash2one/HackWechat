package com.tencent.mm.plugin.wallet.pay;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class b$11 extends b$a {
    final /* synthetic */ b sEl;

    b$11(b bVar, WalletBaseUI walletBaseUI, g gVar) {
        this.sEl = bVar;
        super(bVar, walletBaseUI, gVar);
    }

    public final boolean p(Object... objArr) {
        if (b.a(this.sEl).getInt("key_pay_scene", 0) == 11) {
            p.bJN();
            b.b(this.sEl).putParcelable("key_history_bankcard", p.bJO().sQa);
        }
        return super.p(objArr);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (super.d(i, i2, str, kVar)) {
            return true;
        }
        return false;
    }

    public final boolean k(Object... objArr) {
        return false;
    }
}
