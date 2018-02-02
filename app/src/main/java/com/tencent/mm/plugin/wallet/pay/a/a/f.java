package com.tencent.mm.plugin.wallet.pay.a.a;

import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;

public final class f extends b {
    public f(Authen authen, Orders orders, boolean z) {
        super(authen, orders, z);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlinepayauthen";
    }

    public final int Hr() {
        return 1972;
    }

    public final boolean bhd() {
        if (this.sEt == null || this.sEt.pCn.vzF == 1) {
            return true;
        }
        return false;
    }
}
