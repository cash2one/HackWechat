package com.tencent.mm.plugin.wallet.pay.a.d;

import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.p;

public final class d extends e {
    public d(p pVar, Orders orders) {
        super(pVar, orders);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/ts_verify";
    }

    public final int Hr() {
        return 1699;
    }
}
